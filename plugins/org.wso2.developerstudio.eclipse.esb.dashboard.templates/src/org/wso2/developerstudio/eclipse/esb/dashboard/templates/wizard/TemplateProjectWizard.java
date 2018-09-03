//Liscense

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.IPreferencesService;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.esb.core.ESBMavenConstants;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.wso2.developerstudio.eclipse.utils.template.TemplateUtil;

public class TemplateProjectWizard extends Wizard implements INewWizard {

    private TemplateProjectWizardPage page;
    private ISelection selection;
    private TemplateWizardUtil templateWizardUtil;
    // private File pomfile;
    private String groupId;
    private String version = "1.0.0";
    // ESBProjectArtifact esbProjectArtifact;

    private static final String DISTRIBUTION_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.distribution.project.nature";

    String sampleName = "HelloWorld";
    String containerName;

    public TemplateProjectWizard() {
        super();
        setNeedsProgressMonitor(true);
        templateWizardUtil = new TemplateWizardUtil();
        setWindowTitle(TemplateProjectConstants.PROJECT_WIZARD_TITLE);
    }

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        page = new TemplateProjectWizardPage(selection);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in the wizard. We will
     * create an operation and run it using wizard as execution context.
     */
    @Override
    public boolean performFinish() {

        containerName = page.getContainerName();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, monitor);
                } catch (CoreException e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };

        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), TemplateProjectConstants.ERROR_MESSAGE, realException.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Copy each files which belongs to the samples.
     *
     * @param esbProject
     * @param esbProjectArtifact
     */
    private void copyFiles(IProject esbProject, ESBProjectArtifact esbProjectArtifact) {

        // Copy HelloWorld Proxy
        copyProxy(esbProject, sampleName, sampleName, esbProjectArtifact);

    }

    public void updatePomForProxy(IProject esbProject) throws IOException, XmlPullParserException {
        File mavenProjectPomLocation = esbProject.getFile("pom.xml").getLocation().toFile();
        MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
        version = mavenProject.getVersion();

        // Skip changing the pom file if group ID and artifact ID are matched
        if (MavenUtils.checkOldPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-proxy-plugin")) {
            return;
        }

        Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "wso2-esb-proxy-plugin",
                ESBMavenConstants.WSO2_ESB_PROXY_VERSION, true);
        PluginExecution pluginExecution = new PluginExecution();
        pluginExecution.addGoal("pom-gen");
        pluginExecution.setPhase("process-resources");
        pluginExecution.setId("proxy");

        Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
        Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
        artifactLocationNode.setValue(".");
        Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
        typeListNode.setValue("${artifact.types}");
        pluginExecution.setConfiguration(configurationNode);
        plugin.addExecution(pluginExecution);
        MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
    }

    private void copyProxy(IProject esbProject, String sampleName, String proxyName,
            ESBProjectArtifact esbProjectArtifact) {

        IContainer location = esbProject.getFolder(
                "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                        + "proxy-services");

        try {
            File importFile = getSampleResourceFile();
            IFile proxyServiceFile = location.getFile(new Path(proxyName + ".xml"));
            File destFile = proxyServiceFile.getLocation().toFile();
            FileUtils.copy(importFile, destFile);
            String grpID = groupId + ".proxy-service";
            String relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
                    new File(location.getLocation().toFile(), proxyName + ".xml"))
                    .replaceAll(Pattern.quote(File.separator), "/");
            esbProjectArtifact.addESBArtifact(createArtifact(proxyName, grpID, version, relativePath));
            updatePomForProxy(esbProject);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected File getSampleResourceFile() throws IOException {
        return ProxyServiceTemplateUtils.getInstance().getResourceFile("Samples/HelloWorld/HelloWorld.xml");
    }

    private ESBArtifact createArtifact(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/proxy-service");
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * The worker method. It will find the container, create the file if missing or
     * just replace its contents, and open the editor on the newly created file.
     */
    private void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {
        IProject project = createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);
        File pomfile = project.getFile("pom.xml").getLocation().toFile();
        try {

            groupId = "wso2.sampleTemplate." + containerName;

            createPOM(groupId, pomfile, containerName, "pom");

            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { TemplateProjectConstants.ESB_PROJECT_NATURE });

            ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
            IFile artifactXML = project.getFile("artifact.xml");
            esbProjectArtifact.setSource(artifactXML.getLocation().toFile());
            esbProjectArtifact.toFile();

            copyFiles(project, esbProjectArtifact);

            esbProjectArtifact.toFile();

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            carbonAppCreation(containerName + "CarbonApplication");

        } catch (Exception ex) {
            templateWizardUtil.throwCoreException("Error creating pom file for project " + containerName, ex);
        }
    }

    private void carbonAppCreation(String projectName) {

        try {

            IProject CarbonAppProject = createNewProject(projectName);

            File pomfile = CarbonAppProject.getFile("pom.xml").getLocation().toFile();
            createPOM(pomfile);
            ProjectUtils.addNatureToProject(CarbonAppProject, false, DISTRIBUTION_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { DISTRIBUTION_PROJECT_NATURE });
            CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            List<Dependency> dependencyList = new ArrayList<Dependency>();
            MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
            Properties properties = mavenProject.getModel().getProperties();

            Dependency dependency = new Dependency();

            dependency.setGroupId(groupId + ".proxy-service");
            dependency.setArtifactId(sampleName);
            dependency.setVersion("1.0.0");
            dependency.setType("xml");

            dependencyList.add(dependency);
            properties.put(getArtifactInfoAsString(dependency), "capp/EnterpriseServiceBus");

            ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
            properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());

            mavenProject.getModel().setProperties(properties);

            MavenUtils.addMavenDependency(mavenProject, dependencyList);
            MavenUtils.saveMavenProject(mavenProject, pomfile);
            CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String getArtifactInfoAsString(Dependency dep) {
        String suffix = "";

        String str = suffix.concat(dep.getGroupId().concat("_._").concat(dep.getArtifactId()));
        System.out.println("str get artifact = " + str);
        return str;
    }

    public void createPOM(File pomLocation) throws Exception {

        MavenProject mavenProject = MavenUtils
                .createMavenProject(groupId, containerName + "CarbonApp", version, "carbon/application");

        Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();

        //	System.out.println("============== getGlobalRepositoryFromPreference ============");
        mavenProject.getModel().addRepository(globalRepositoryFromPreference);
        mavenProject.getModel().addPluginRepository(globalRepositoryFromPreference);

        ///////
     String MAVEN_CAR_VERSION = "2.1.1";
     String MAVEN_CAR_DEPLOY_VERSION = "1.1.1";
        Plugin plugin = MavenUtils
                .createPluginEntry(mavenProject, "org.wso2.maven", "maven-car-plugin", MAVEN_CAR_VERSION,
                        true);
        PluginExecution pluginExecution;

        pluginExecution = new PluginExecution();
        pluginExecution.addGoal("car");
        pluginExecution.setPhase("package");
        pluginExecution.setId("car");
        plugin.addExecution(pluginExecution);

        Plugin carDeployPlugin = MavenUtils.createPluginEntry(mavenProject, "org.wso2.maven", "maven-car-deploy-plugin",
                MAVEN_CAR_DEPLOY_VERSION, true);
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

    public IProject createNewProject(String name) throws CoreException {

        IProject project = null;

        project = createProjectInDefaultWorkspace(name);

        return project;
    }

    private IProject createProjectInDefaultWorkspace(String name) throws CoreException {

        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(name);
        project.create(new NullProgressMonitor());
        project.open(new NullProgressMonitor());

        return project;
    }

    /**
     * Create the POM file for the project.
     *
     * @param pomLocation
     * @param projectName
     * @throws Exception
     */ 
    public void createPOM(String groupID, File pomLocation, String projectName, String packaging) throws Exception {
        MavenProject mavenProjects = MavenUtils.createMavenProject(groupID, projectName, version, packaging);
        MavenUtils.updateMavenRepo(mavenProjects);
        Repository globalRepositoryFromPreference = getGlobalRepositoryFromPreference();

        //	System.out.println("============== getGlobalRepositoryFromPreference ============");
        mavenProjects.getModel().addRepository(globalRepositoryFromPreference);
        mavenProjects.getModel().addPluginRepository(globalRepositoryFromPreference);

        MavenUtils.saveMavenProject(mavenProjects, pomLocation);
    }

    protected Repository getGlobalRepositoryFromPreference() {

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

    public IProject createProject(String containerName, String natureID) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(containerName);
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

    /**
     * Will accept the selection in the workbench to see if we can initialize from
     * it.
     *
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setHelpAvailable(true);
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
