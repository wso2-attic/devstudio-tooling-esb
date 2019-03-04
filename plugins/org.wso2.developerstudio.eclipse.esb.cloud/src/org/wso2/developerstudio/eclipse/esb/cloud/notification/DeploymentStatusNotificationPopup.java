package org.wso2.developerstudio.eclipse.esb.cloud.notification;

import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudDeploymentWizardConstants;

public class DeploymentStatusNotificationPopup extends AbstractNotificationPopup{
    
    private String message;
    private String title;
    
    public DeploymentStatusNotificationPopup(Display display, String title, String message) {
        super(display);
        this.message = message;
        this.title = title;
    }
    
    @Override
    protected void createContentArea(Composite parent) {
        parent.setLayout(new GridLayout(1, false));
        
        Label successMsg = new Label(parent, SWT.NULL);
        successMsg.setText(this.message);
        
    }
    
    @Override
    protected String getPopupShellTitle() {
        return this.title;
    }
}
