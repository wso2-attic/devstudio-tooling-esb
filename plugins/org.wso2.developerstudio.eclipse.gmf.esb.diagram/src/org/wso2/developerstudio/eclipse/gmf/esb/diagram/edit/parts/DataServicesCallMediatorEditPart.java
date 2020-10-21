package org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.parts;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.EsbGraphicalShape;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.DataServicesCallMediatorCanonicalEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.edit.policies.DataServicesCallMediatorItemSemanticEditPolicy;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.part.EsbVisualIDRegistry;

/**
 * @generated
 */
public class DataServicesCallMediatorEditPart extends AbstractBorderedShapeEditPart {

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
    protected IFigure primaryShape;

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
        installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new DataServicesCallMediatorCanonicalEditPolicy());
        installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
        // XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
        // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
    }

    /**
    * @generated
    */
    protected LayoutEditPolicy createLayoutEditPolicy() {

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
    }

    /**
    * @generated
    */
    protected IFigure createNodeShape() {
        return primaryShape = new DataServicesCallMediatorFigure();
    }

    /**
    * @generated
    */
    public DataServicesCallMediatorFigure getPrimaryShape() {
        return (DataServicesCallMediatorFigure) primaryShape;
    }

    /**
    * @generated
    */
    protected boolean addFixedChild(EditPart childEditPart) {
        if (childEditPart instanceof DataServicesCallMediatorDescriptionEditPart) {
            ((DataServicesCallMediatorDescriptionEditPart) childEditPart)
                    .setLabel(getPrimaryShape().getFigureDataServicesCallMediatorDescriptionFigure());
            return true;
        }
        if (childEditPart instanceof DataServicesCallMediatorInputConnectorEditPart) {
            BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.WEST);
            getBorderedFigure().getBorderItemContainer()
                    .add(((DataServicesCallMediatorInputConnectorEditPart) childEditPart).getFigure(), locator);
            return true;
        }
        if (childEditPart instanceof DataServicesCallMediatorOutputConnectorEditPart) {
            BorderItemLocator locator = new BorderItemLocator(getMainFigure(), PositionConstants.EAST);
            getBorderedFigure().getBorderItemContainer()
                    .add(((DataServicesCallMediatorOutputConnectorEditPart) childEditPart).getFigure(), locator);
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
    protected NodeFigure createNodePlate() {
        DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
        return result;
    }

    /**
    * Creates figure for this edit part.
    * 
    * Body of this method does not depend on settings in generation model
    * so you may safely remove <i>generated</i> tag and modify it.
    * 
    * @generated
    */
    protected NodeFigure createMainFigure() {
        NodeFigure figure = createNodePlate();
        figure.setLayoutManager(new StackLayout());
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
    public EditPart getPrimaryChildEditPart() {
        return getChildBySemanticHint(
                EsbVisualIDRegistry.getType(DataServicesCallMediatorDescriptionEditPart.VISUAL_ID));
    }

    /**
     * @generated
     */
    public class DataServicesCallMediatorFigure extends EsbGraphicalShape {

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
        public DataServicesCallMediatorFigure() {

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
        }

        /**
         * @generated
         */
        private void createContents() {

            fFigureDataServicesCallMediatorPropertyLabel = new WrappingLabel();

            fFigureDataServicesCallMediatorPropertyLabel.setText("<...>");

            this.add(fFigureDataServicesCallMediatorPropertyLabel);

            fFigureDataServicesCallMediatorDescriptionFigure = new WrappingLabel();

            fFigureDataServicesCallMediatorDescriptionFigure.setText("<...>");

            this.add(fFigureDataServicesCallMediatorDescriptionFigure);

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

    }

    /**
     * @generated
     */
    static final Color THIS_BACK = new Color(null, 230, 230, 230);

}
