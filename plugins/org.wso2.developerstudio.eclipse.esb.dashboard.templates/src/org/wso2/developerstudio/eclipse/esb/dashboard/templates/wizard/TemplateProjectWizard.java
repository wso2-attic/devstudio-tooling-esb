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
import org.apache.maven.project.MavenProject;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.osgi.framework.Bundle;
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
     * This method is called when 'Finish' button is pressed in the wizard. We
     * will create an operation and run it using wizard as execution context.
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
        } catch (IOException e) {
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
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     */
    private void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {
        IProject project = createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);
        File pomfile = project.getFile("pom.xml").getLocation().toFile();
        try {

            groupId = "wso2.sampleTemplate." + containerName;

            createPOM(groupId, pomfile, containerName, "pom");
            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);
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
            dependency.setArtifactId(sampleName + ".xml");
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
        MavenProject mavenProject = MavenUtils.createMavenProject(groupID, projectName, version, packaging);
        MavenUtils.updateMavenRepo(mavenProject);
//        mavenProject.getModel().addRepository(globalRepositoryFromPreference);
//	mavenProject.getModel().addPluginRepository(globalRepositoryFromPreference);
        MavenUtils.saveMavenProject(mavenProject, pomLocation);
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
     * Will accept the selection in the workbench to see if we can initialize
     * from it.
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

