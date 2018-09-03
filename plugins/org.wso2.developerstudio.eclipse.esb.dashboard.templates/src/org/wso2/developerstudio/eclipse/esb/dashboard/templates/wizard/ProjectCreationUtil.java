/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.wso2.developerstudio.eclipse.utils.template.TemplateUtil;

/**
 * Util class to for sample template creation.
 */
public class ProjectCreationUtil {

    private static final String DISTRIBUTION_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.distribution.project.nature";
    private static String MAVEN_CAR_VERSION = "2.1.1";
    private static String MAVEN_CAR_DEPLOY_VERSION = "1.1.1";
    private static String version = "1.0.0";

    public static IProject createProject(String containerName, String natureID) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(containerName);
        TemplateWizardUtil templateWizardUtil = new TemplateWizardUtil();
        if (project.exists()) {
            templateWizardUtil
                    .throwCoreException(TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
        } else {
            project.create(null);
            project.open(null);
        }

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            templateWizardUtil.throwCoreException("Container \"" + containerName + "\" does not exist.", null);
        }
        return project;
    }

    public static void createProjectPOM(String groupID, File pomLocation, String projectName, String packaging)
            throws Exception {
        MavenProject mavenProjects = MavenUtils.createMavenProject(groupID, projectName, "1.0.0", packaging);
        MavenUtils.updateMavenRepo(mavenProjects);
        Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();
        mavenProjects.getModel().addRepository(globalRepositoryFromPreference);
        mavenProjects.getModel().addPluginRepository(globalRepositoryFromPreference);
        MavenUtils.saveMavenProject(mavenProjects, pomLocation);
    }

    public static void createCarbonAppPOM(File pomLocation, String groupId, String containerName) throws Exception {

        String artifactID = containerName + "CarbonApplication";

        MavenProject mavenProject = MavenUtils.createMavenProject(groupId, artifactID, "1.0.0", "carbon/application");

        Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();
        mavenProject.getModel().addRepository(globalRepositoryFromPreference);
        mavenProject.getModel().addPluginRepository(globalRepositoryFromPreference);
        Plugin plugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", "maven-car-plugin", MAVEN_CAR_VERSION, true);
        PluginExecution pluginExecution;
        pluginExecution = new PluginExecution();
        pluginExecution.addGoal("car");
        pluginExecution.setPhase("package");
        pluginExecution.setId("car");
        plugin.addExecution(pluginExecution);
        Plugin carDeployPlugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", "maven-car-deploy-plugin", MAVEN_CAR_DEPLOY_VERSION,
                        true);
        Xpp3Dom carDeployConfElement = MavenUtils.createMainConfigurationNode(carDeployPlugin);
        Xpp3Dom serversElement = MavenUtils.createXpp3Node(carDeployConfElement, "carbonServers");
        Xpp3Dom carbonServer = MavenUtils.createXpp3Node(serversElement, "CarbonServer");
        Xpp3Dom trustStore = MavenUtils.createXpp3Node(carbonServer, "trustStorePath");
        trustStore.setValue("${basedir}/src/main/resources/security/wso2carbon.jks");
        Xpp3Dom trustStorePW = MavenUtils.createXpp3Node(carbonServer, "trustStorePassword");
        trustStorePW.setValue("wso2carbon");
        Xpp3Dom trustStoreType = MavenUtils.createXpp3Node(carbonServer, "trustStoreType");
        trustStoreType.setValue("JKS");
        Xpp3Dom serverUrl = MavenUtils.createXpp3Node(carbonServer, "serverUrl");
        serverUrl.setValue("https://localhost:9443");
        Xpp3Dom serverUserName = MavenUtils.createXpp3Node(carbonServer, "userName");
        serverUserName.setValue("admin");
        Xpp3Dom serverPW = MavenUtils.createXpp3Node(carbonServer, "password");
        serverPW.setValue("admin");
        Xpp3Dom serverOperation = MavenUtils.createXpp3Node(carbonServer, "operation");
        serverOperation.setValue("deploy");

        Repository repo = new Repository();
        repo.setUrl("http://dist.wso2.org/maven2");
        repo.setId("wso2-maven2-repository-1");

        Repository repo1 = new Repository();
        repo1.setUrl("http://maven.wso2.org/nexus/content/groups/wso2-public/");
        repo1.setId("wso2-nexus-repository-1");

        mavenProject.getModel().addRepository(repo);
        mavenProject.getModel().addPluginRepository(repo);

        mavenProject.getModel().addRepository(repo1);
        mavenProject.getModel().addPluginRepository(repo1);

        MavenUtils.saveMavenProject(mavenProject, pomLocation);
    }

    protected static Repository getGlobalRepositoryFromPreference() {

        String repoURL = "http://maven.wso2.org/nexus/content/groups/wso2-public/";
        String id = "wso2-nexus";
        Repository repo = new Repository();
        repo.setUrl(repoURL);
        repo.setId(id);

        RepositoryPolicy releasePolicy = new RepositoryPolicy();

        releasePolicy.setEnabled(true);
        releasePolicy.setUpdatePolicy("daily");
        releasePolicy.setChecksumPolicy("ignore");
        repo.setReleases(releasePolicy);
        return repo;
    }

    public static void copyArtifact(IProject esbProject, String groupId, String sampleName, String artifactName,
            ESBProjectArtifact esbProjectArtifact, String type) {

        IContainer location = esbProject
                .getFolder("src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + type);

        try {
            File importFile = getResourceFile(sampleName, artifactName, type);
            IFile proxyServiceFile = location.getFile(new Path(artifactName + ".xml"));
            File destFile = proxyServiceFile.getLocation().toFile();
            FileUtils.copy(importFile, destFile);

            String relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
                    new File(location.getLocation().toFile(), artifactName + ".xml"))
                    .replaceAll(Pattern.quote(File.separator), "/");

            String artifactType = type;
            if (type.equals("proxy-services")) {
                artifactType = "proxy-service";
            } else if (type.equals("endpoints")) {
                artifactType = "endpoint";
            }

            String grpID = groupId + "." + artifactType;

            esbProjectArtifact.addESBArtifact(createArtifact(artifactName, grpID, version, relativePath, artifactType));

            if (type.equals("proxy-services")) {
                type = "proxy";
            }
            updatePomForArtifact(esbProject, type);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void updatePomForArtifact(IProject esbProject, String type)
            throws IOException, XmlPullParserException {

        String pluginName = null;

        if (type.equals("api")) {
            pluginName = "wso2-esb-api-plugin";
        } else if (type.equals("proxy")) {
            pluginName = "wso2-esb-proxy-plugin";
        }

        File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", pluginName)) {
            return;
        }

        Plugin plugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", pluginName, ESBMavenConstants.WSO2_ESB_PROXY_VERSION,
                        true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId(type);

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    protected static File getResourceFile(String samplename, String name, String type) throws IOException {

        String fileLocation = "Samples" + File.separator + samplename + File.separator + "src" + File.separator + "main"
                + File.separator + "synapse-config" + File.separator + type + File.separator + name + ".xml";

        return ProxyServiceTemplateUtils.getInstance().getResourceFile(fileLocation);
    }

    private static ESBArtifact createArtifact(String name, String groupId, String version, String path, String type) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/" + type);
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    public static IProject carbonAppCreation(String projectName, String containerName, String groupId,
            String sampleName) {

        try {

            IProject CarbonAppProject = createNewProject(projectName);

            File pomfile = CarbonAppProject.getFile("pom.xml").getLocation().toFile();
            ProjectCreationUtil.createCarbonAppPOM(pomfile, groupId, containerName);
            ProjectUtils.addNatureToProject(CarbonAppProject, false, DISTRIBUTION_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { DISTRIBUTION_PROJECT_NATURE });
            CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            return CarbonAppProject;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public static Dependency addDependencyForCAPP(String groupId, String artifactName, String type) {
        Dependency dependency = new Dependency();
        dependency.setGroupId(groupId + "." + type);
        dependency.setArtifactId(artifactName);
        dependency.setVersion("1.0.0");
        dependency.setType("xml");
        return dependency;

    }

    public static String getArtifactInfoAsString(Dependency dep) {
        String suffix = "";

        String str = suffix.concat(dep.getGroupId().concat("_._").concat(dep.getArtifactId()));
        return str;
    }

    private static IProject createNewProject(String name) throws CoreException {

        IProject project = null;

        project = createProjectInDefaultWorkspace(name);

        return project;
    }

    private static IProject createProjectInDefaultWorkspace(String name) throws CoreException {

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        project.create(new NullProgressMonitor());
        project.open(new NullProgressMonitor());

        return project;
    }

}

class ProxyServiceTemplateUtils extends TemplateUtil {

    private static TemplateUtil instance;

    public static TemplateUtil getInstance() {
        if (instance == null) {
            instance = new ProxyServiceTemplateUtils();
        }
        return instance;
    }

    protected Bundle getBundle() {
        return Platform.getBundle(org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator.PLUGIN_ID);
    }
}

class ArtifactTypeMapping {
    private static final String ARTIFACT_TYPE = "artifactType";
    private static final String FILE_EXTENSION = "fileExtension";
    private static final String REGISTER_ARTIFACT_MAPPING_EXTENSION_ID = "org.wso2.developerstudio.register.artifact.mapping";
    private static Map<String, String> type = new HashMap<String, String>();
    private static Map<String, String> subType = new HashMap<String, String>();

    public ArtifactTypeMapping() {
        DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
        IConfigurationElement[] artifactMappings = devStudioUtils
                .getExtensionPointmembers(REGISTER_ARTIFACT_MAPPING_EXTENSION_ID);
        for (IConfigurationElement artifactmapping : artifactMappings) {
            type.put(artifactmapping.getAttribute(ARTIFACT_TYPE), artifactmapping.getAttribute(FILE_EXTENSION));
        }
        subType.put("jar", "jar");
        subType.put("bundle", "jar");

    }

    public boolean isValidArtifactType(final String str) {
        return type.containsKey(str);
    }

    public String getType(final String packaging) {
        String value = "";
        if (type.containsKey(packaging)) {
            value = type.get(packaging);
        } else {
            if (subType.containsKey(packaging)) {
                value = subType.get(packaging);
            } else {
                value = packaging.replaceAll("/", "_");
            }
        }
        return value;
    }

    public String getArtifactTypes() {
        StringBuffer artifactTypes = new StringBuffer();
        for (String key : type.keySet()) {
            artifactTypes.append(key);
            artifactTypes.append("=");
            artifactTypes.append(type.get(key));
            artifactTypes.append(',');
        }
        return artifactTypes.toString().replaceAll(",$", "");
    }

}

