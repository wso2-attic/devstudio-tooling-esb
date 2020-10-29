package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.apache.commons.lang.StringUtils;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSNodeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShapeWithLabel;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedBorderItemLocator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.FixedSizedAbstractMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.editpolicy.FeedbackIndicateDragDropEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.utils.CustomToolTip;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.DataServicesCallMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.DataServicesCallMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.validator.GraphicalValidatorUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DATASERVICESCALL_MEDIATOR_ICON_PATH;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts.EditPartConstants.DEFAULT_PROPERTY_VALUE_TEXT;

/**
 * @generated
 */
public class DataServicesCallMediatorEditPart extends FixedSizedAbstractMediator {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    /**
    * @generated
    */
    public static final int VISUAL_ID = 3794;

    /**
    * @generated
    */
    protected IFigure contentPane;

    /**
    * @generated
    */
    //protected IFigure primaryShape;

    /**
    * @generated
    */
    public DataServicesCallMediatorEditPart(View view) {
        super(view);
    }

    /**
    * @generated
    */
    protected void createDefaultEditPolicies() {
        installEditPolicy(EditPolicyRoles.CREATION_ROLE,
                new CreationEditPolicyWithCustomReparent(EsbVisualIDRegistry.TYPED_INSTANCE));
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DataServicesCallMediatorItemSemanticEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new FeedbackIndicateDragDropEditPolicy());
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DataServicesCallMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
        removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
    * @generated
    */
    /*protected LayoutEditPolicy createLayoutEditPolicy() {

        FlowLayoutEditPolicy lep = new FlowLayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                case DataServicesCallMediatorInputConnectorEditPart.VISUAL_ID:
                case DataServicesCallMediatorOutputConnectorEditPart.VISUAL_ID:
                    return new BorderItemSelectionEditPolicy();
                }
                return super.createChildEditPolicy(child);
            }

            protected Command createAddCommand(EditPart child, EditPart after) {
                return null;
            }

            protected Command createMoveChildCommand(EditPart child, EditPart after) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }*/

    protected LayoutEditPolicy createLayoutEditPolicy() {

        org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

            protected EditPolicy createChildEditPolicy(EditPart child) {
                View childView = (View) child.getModel();
                switch (EsbVisualIDRegistry.getVisualID(childView)) {
                    case DataServicesCallMediatorInputConnectorEditPart.VISUAL_ID:
                    case DataServicesCallMediatorOutputConnectorEditPart.VISUAL_ID:
                        return new BorderItemSelectionEditPolicy();
                }
                EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
                if (result == null) {
                    result = new NonResizableEditPolicy();
                }
                return result;
            }

            protected Command getMoveChildrenCommand(Request request) {
                return null;
            }

            protected Command getCreateCommand(CreateRequest request) {
                return null;
            }
        };
        return lep;
    }

    /**
    * @generated NOT
    */
    protected IFigure createNodeShape() {
        return primaryShape = new DataServicesCallMediatorFigure(new Color(null, 255, 255, 255)) {
            public void setBounds(org.eclipse.draw2d.geometry.Rectangle rect) {
                super.setBounds(rect);
                if (this.getBounds().getLocation().x != 0 && this.getBounds().getLocation().y != 0) {
                    connectToMostSuitableElement();
                    reAllocate(rect);
                }
            };
        };
    }

    /**
    * @generated
    */
    public DataServicesCallMediatorFigure getPrimaryShape() {
        return (DataServicesCallMediatorFigure) primaryShape;
    }

    /**
    * @generated NOT
    */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof DataServicesCallMediatorDescriptionEditPart) {
            ((DataServicesCallMediatorDescriptionEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getFigureDataServicesCallMediatorDescriptionFigure());
            return true;
        }
        if (childEditPart instanceof DataServicesCallMediatorInputConnectorEditPart) {
            IFigure borderItemFigure = ((DataServicesCallMediatorInputConnectorEditPart) childEditPart).getFigure();
//            BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.WEST);
//            getBorderedFigure().getBorderItemContainer()
//                    .add(((DataServicesCallMediatorInputConnectorEditPart) childEditPart).getFigure(), locator);
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.WEST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        if (childEditPart instanceof DataServicesCallMediatorOutputConnectorEditPart) {
            IFigure borderItemFigure = ((DataServicesCallMediatorOutputConnectorEditPart) childEditPart).getFigure();
            //BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.EAST);
            //getBorderedFigure().getBorderItemContainer()
            //       .add(((DataServicesCallMediatorOutputConnectorEditPart) childEditPart).getFigure(), locator);
            BorderItemLocator locator = new FixedBorderItemLocator(getMainFigure(), borderItemFigure,
                    PositionConstants.EAST, 0.5);
            getBorderedFigure().getBorderItemContainer().add(borderItemFigure, locator);
            return true;
        }
        return false;
    }

    /**
    * @generated
    */
    protected boolean removeFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof DataServicesCallMediatorDescriptionEditPart) {
            return true;
        }
        if (childEditPart instanceof DataServicesCallMediatorInputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((DataServicesCallMediatorInputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        if (childEditPart instanceof DataServicesCallMediatorOutputConnectorEditPart) {
            getBorderedFigure().getBorderItemContainer()
                    .remove(((DataServicesCallMediatorOutputConnectorEditPart) childEditPart).getFigure());
            return true;
        }
        return false;
    }

    /**
    * @generated
    */
    protected void addChildVisual(EditPart childEditPart, int index) {
        if (addFixedChild(childEditPart)) {
            return;
        }
        super.addChildVisual(childEditPart, -1);
    }

    /**
    * @generated
    */
    protected void removeChildVisual(EditPart childEditPart) {
        if (removeFixedChild(childEditPart)) {
            return;
        }
        super.removeChildVisual(childEditPart);
    }

    /**
    * @generated
    */
    protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
        if (editPart instanceof IBorderItemEditPart) {
            return getBorderedFigure().getBorderItemContainer();
        }
        return getContentPane();
    }

    /**
    * @generated
    */
    /*protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }*/

    /**
    * Creates figure for this edit part.
    * 
    * Body of this method does not depend on settings in generation model
    * so you may safely remove <i>generated</i> tag and modify it.
    * 
    * @generated NOT
    */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new ToolbarLayout(true));
        //figure.setLayoutManager(new StackLayout());
        IFigure shape = createNodeShape();
        figure.add(shape);
        contentPane = setupContentPane(shape);
        return figure;
    }

    /**
    * Default implementation treats passed figure as content pane.
    * Respects layout one may have set for generated figure.
    * @param nodeShape instance of generated figure class
    * @generated
    */
    protected IFigure setupContentPane(IFigure nodeShape) {
        if (nodeShape.getLayoutManager() == null) {
            ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
            layout.setSpacing(5);
            nodeShape.setLayoutManager(layout);
        }
        return nodeShape; // use nodeShape itself as contentPane
    }

    /**
    * @generated
    */
    public IFigure getContentPane() {
        if (contentPane != null) {
            return contentPane;
        }
        return super.getContentPane();
    }

    /**
    * @generated
    */
    protected void setForegroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setForegroundColor(color);
        }
    }

    /**
    * @generated
    */
    protected void setBackgroundColor(Color color) {
        if (primaryShape != null) {
            primaryShape.setBackgroundColor(color);
        }
    }

    /**
    * @generated
    */
    protected void setLineWidth(int width) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineWidth(width);
        }
    }

    /**
    * @generated
    */
    protected void setLineType(int style) {
        if (primaryShape instanceof Shape) {
            ((Shape) primaryShape).setLineStyle(style);
        }
    }

    /**
    * @generated
    */
//    public EditPart getPrimaryChildEditPart() {
//        return getChildBySemanticHint(
//                EsbVisualIDRegistry.getType(DataServicesCallMediatorDescriptionEditPart.VISUAL_ID));
//    }

    /**
     * @generated
     */
    public class DataServicesCallMediatorFigure extends EsbGraphicalShapeWithLabel   {

        /**
         * @generated
         */
        private WrappingLabel fFigureDataServicesCallMediatorPropertyLabel;
        /**
         * @generated
         */
        private WrappingLabel fFigureDataServicesCallMediatorDescriptionFigure;

        /**
         * @generated
         */
        /*public DataServicesCallMediatorFigure() {

            FlowLayout layoutThis = new FlowLayout();
            layoutThis.setStretchMinorAxis(false);
            layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

            layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
            layoutThis.setMajorSpacing(5);
            layoutThis.setMinorSpacing(5);
            layoutThis.setHorizontal(true);

            this.setLayoutManager(layoutThis);

            this.setBackgroundColor(THIS_BACK);
            createContents();
        }*/

        public DataServicesCallMediatorFigure(Color borderColor) {

            super(borderColor, false);
            this.setBackgroundColor(THIS_BACK);
            createContents();
        }

        /**
         * @generated NOT
         */
        private void createContents() {

            fFigureDataServicesCallMediatorPropertyLabel = new WrappingLabel();

            fFigureDataServicesCallMediatorPropertyLabel.setText(DEFAULT_PROPERTY_VALUE_TEXT);
            fFigureDataServicesCallMediatorPropertyLabel.setAlignment(SWT.CENTER);

            fFigureDataServicesCallMediatorDescriptionFigure = getPropertyNameLabel();

            /*fFigureDataServicesCallMediatorPropertyLabel.setText("<...>");

            this.add(fFigureDataServicesCallMediatorPropertyLabel);

            fFigureDataServicesCallMediatorDescriptionFigure = new WrappingLabel();

            fFigureDataServicesCallMediatorDescriptionFigure.setText("<...>");

            this.add(fFigureDataServicesCallMediatorDescriptionFigure);*/

        }

        /**
         * @generated
         */
        public WrappingLabel getFigureDataServicesCallMediatorPropertyLabel() {
            return fFigureDataServicesCallMediatorPropertyLabel;
        }

        /**
         * @generated
         */
        public WrappingLabel getFigureDataServicesCallMediatorDescriptionFigure() {
            return fFigureDataServicesCallMediatorDescriptionFigure;
        }

        public String getIconPath() {
            return DATASERVICESCALL_MEDIATOR_ICON_PATH;
        }

        public String getNodeName() {
            return Messages.DataServicesCallMediatorEditPart_NodeName;
        }

        public IFigure getToolTip() {
            if (StringUtils.isEmpty(toolTipMessage)) {
                toolTipMessage = Messages.DataServicesCallMediatorEditPart_ToolTipMessage;
            }
            return new CustomToolTip().getCustomToolTipShape(toolTipMessage);
        }

    }

    @Override
    public void notifyChanged(Notification notification) {
        // This will validate the dataServiceCall mediator data object
        if (notification.getEventType() == Notification.SET && this.getModel() instanceof CSSNodeImpl) {
            CSSNodeImpl model = (CSSNodeImpl) this.getModel();
            if (model.getElement() instanceof DataServicesCallMediatorImpl) {
                DataServicesCallMediatorImpl dataServicesCallMediatorDataModel = (DataServicesCallMediatorImpl) model.getElement();
                try {
                    boolean noServiceName = dataServicesCallMediatorDataModel.getServiceName() == null;
                    boolean noSource = dataServicesCallMediatorDataModel.getSourceType() == null;
                    boolean noTarget = dataServicesCallMediatorDataModel.getTargetType() == null;
                    if (noServiceName && noSource && noTarget) {
                        GraphicalValidatorUtil.addValidationMark(this);
                    } else {
                        GraphicalValidatorUtil.removeValidationMark(this);
                    }
                } catch (Exception e) {
                    // Skip error since it's a validation related minor issue
                    log.error("Graphical validation error occured", e);
                }
            }
        }
        super.notifyChanged(notification);
    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 230, 230, 230);

}
