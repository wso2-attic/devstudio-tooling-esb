package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.w3c.dom.Document;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSProjectArtifact;

public class DataServicesCallMediatorPropertiesUtil {

	public static Map<String, Document> getAvailableDataServicesListFromProject(Composite parent) {

        String dssArtifcatCategory = "service/dataservice";
        Map<String, Document> availableDataServicesMap = new HashMap<String, Document>();
        File projectPath = null;
        final Shell shell = (Shell) parent.getShell();
        if (shell.getDisplay().getActiveShell() != null) {
	        final IEditorPart editor = (IEditorPart) ((WorkbenchWindow) shell.getDisplay().getActiveShell().getData())
	                .getActivePage().getActiveEditor();
	        if (editor != null) {
	            // IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
	            // IFile file = input.getFile();
	            // IProject workspaceProject = file.getProject();

	            // Fixing TOOLS-2322
	            IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
	            for (IProject workspaceProject : projects) {
	                try {
	                    if (workspaceProject.hasNature("org.wso2.developerstudio.eclipse.ds.project.nature")) {
	                    	DSSProjectArtifact dssProjectArtifact = new DSSProjectArtifact();
							String projectName = workspaceProject.getFullPath().segment(workspaceProject.getFullPath().segmentCount() -1);
	                        projectPath = workspaceProject.getLocation().toFile();
	                        try {
	                        	dssProjectArtifact
	                                    .fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
	                            List<DSSArtifact> allDSSArtifacts = dssProjectArtifact.getAllDSSArtifacts();
	                            for (DSSArtifact dssArtifact : allDSSArtifacts) {
	                                if (dssArtifcatCategory.equals(dssArtifact.getType())) {
	                                    File artifact = new File(projectPath, dssArtifact.getFile());
	                                    String name = projectName + "/" + artifact.getName().replaceAll("[.]dbs$", "");
	                                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	                                	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	                            	    Document doc = dBuilder.parse(artifact);
	                                    availableDataServicesMap.put(name, doc);
	                                }
	                            }
	                        } catch (Exception e) {
	                            ErrorDialog.openError(shell, "Error occured while scanning the project for "
	                                    + dssArtifcatCategory + " artifacts", e.getMessage(), null);
	                        }
	                    }
	                } catch (CoreException e) {
	                    ErrorDialog.openError(shell, "Error occured while scanning the project", e.getMessage(), null);
	                }
	            }
	        }
        }
        return availableDataServicesMap;
    }

}
