/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.w3c.dom.Document;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallOperationsPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.DataServicesCallMediatorPropertiesUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class DataServicesCallOperationsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, DataServicesCallOperationsPropertiesEditionPart {

	protected EMFComboViewer operationName;
	private String serviceName; 
	private String opName; 
	//protected Control[] paramsElements;
	protected Group propertiesGroup;
	Map<String, Document> availableDataServicesMap;
	protected static String OPERATION_DEFAULT_VALUE = "Select From Operations";


	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataServicesCallOperationsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
		if (editionComponent.getEditingContext() != null && editionComponent.getEditingContext().getEObject() != null && 
				editionComponent.getEditingContext().getEObject().eContainer() != null && editionComponent.getEditingContext().getEObject().eContainer() 
				instanceof DataServicesCallMediatorImpl) {
			serviceName = ((DataServicesCallMediatorImpl)editionComponent.getEditingContext().getEObject().eContainer()).getServiceName();
			opName = ((DataServicesCallMediatorImpl)editionComponent.getEditingContext().getEObject().eContainer()).getOperationName();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence dataServicesCallOperationsStep = new BindingCompositionSequence(propertiesEditionComponent);
		dataServicesCallOperationsStep
			.addStep(EsbViewsRepository.DataServicesCallOperations.Properties.class)
			.addStep(EsbViewsRepository.DataServicesCallOperations.Properties.operationName);
		
		
		composer = new PartComposer(dataServicesCallOperationsStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DataServicesCallOperations.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.DataServicesCallOperations.Properties.operationName) {
					return createOperationNameText(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.DataServicesCallOperationsPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createOperationNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServicesCallOperations.Properties.operationName, EsbMessages.DataServicesCallOperationsPropertiesEditionPart_OperationNameLabel);
		operationName = new EMFComboViewer(parent);
		operationName.setContentProvider(new ArrayContentProvider());
		Map<String, Document> currentDataServicesMap = DataServicesCallMediatorPropertiesUtil.getAvailableDataServicesListFromProject(parent);
		if (!currentDataServicesMap.isEmpty()) {
			availableDataServicesMap = currentDataServicesMap;
		}
		Map<String, List<String>> operationsMap = getAllAvailableOperations(getServiceName(), availableDataServicesMap);
		List <String> availableOperationsList = new ArrayList<>();
		availableOperationsList.add(OPERATION_DEFAULT_VALUE);
		availableOperationsList.addAll(operationsMap.keySet());
		operationName.setInput(availableOperationsList);
		operationName.getCombo().select(0);
		operationName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		GridData dSNameData = new GridData(GridData.FILL_HORIZONTAL);
		operationName.getCombo().setLayoutData(dSNameData);
		operationName.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
		EditingUtils.setID(operationName.getCombo(), EsbViewsRepository.DataServicesCallOperations.Properties.operationName);
		EditingUtils.setEEFtype(operationName.getCombo(), "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallOperations.Properties.operationName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationNameText
		operationName.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
            	propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallOperationsPropertiesEditionPartImpl.this, EsbViewsRepository.DataServicesCallOperations.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.CHANGE, operationsMap.get(operationName.getCombo().getText()), operationName.getCombo().getText()));
            	//params.refresh();
            	refresh();
//                for (String paramName : operationsMap.get(operationName.getCombo().getText())) {
//                	ParamImpl param = new ParamImpl();
//                    param.setParamName(paramName);		
//	                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.params, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, param));
//					params.refresh();
//                }
            }

        });
		// End of user code
		return parent;
	}
//		createDescription(parent, EsbViewsRepository.DataServicesCallOperations.Properties.operationName, EsbMessages.DataServicesCallOperationsPropertiesEditionPart_OperationNameLabel);
//		operationName = SWTUtils.createScrollableText(parent, SWT.BORDER);
//		GridData operationNameData = new GridData(GridData.FILL_HORIZONTAL);
//		operationName.setLayoutData(operationNameData);
//		operationName.addFocusListener(new FocusAdapter() {
//
//			/**
//			 * {@inheritDoc}
//			 * 
//			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
//			 * 
//			 */
//			@Override
//			@SuppressWarnings("synthetic-access")
//			public void focusLost(FocusEvent e) {
//				if (propertiesEditionComponent != null)
//					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallOperationsPropertiesEditionPartImpl.this, EsbViewsRepository.DataServicesCallOperations.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
//			}
//
//		});
//		operationName.addKeyListener(new KeyAdapter() {
//
//			/**
//			 * {@inheritDoc}
//			 * 
//			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
//			 * 
//			 */
//			@Override
//			@SuppressWarnings("synthetic-access")
//			public void keyPressed(KeyEvent e) {
//				if (e.character == SWT.CR) {
//					if (propertiesEditionComponent != null)
//						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallOperationsPropertiesEditionPartImpl.this, EsbViewsRepository.DataServicesCallOperations.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, operationName.getText()));
//				}
//			}
//
//		});
//		EditingUtils.setID(operationName, EsbViewsRepository.DataServicesCallOperations.Properties.operationName);
//		EditingUtils.setEEFtype(operationName, "eef::Text"); //$NON-NLS-1$
//		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallOperations.Properties.operationName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
//		// Start of user code for createOperationNameText
//
//		// End of user code
//		return parent;
//	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallOperationsPropertiesEditionPart#getOperationName()
	 * 
	 */
	public String getOperationName() {
		return operationName.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallOperationsPropertiesEditionPart#setOperationName(String newValue)
	 * 
	 */
	public void setOperationName(String newValue) {
		if (newValue != null) {
			operationName.getCombo().setText(newValue);
		} else {
			operationName.getCombo().setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallOperations.Properties.operationName);
		if (eefElementEditorReadOnlyState && operationName.isEnabled()) {
			operationName.setEnabled(false);
			operationName.setToolTipText(EsbMessages.DataServicesCallOperations_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationName.isEnabled()) {
			operationName.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DataServicesCallOperations_Part_Title;
	}

	// Start of user code additional methods
	
	protected Map<String, List<String>> getAllAvailableOperations(String DSName, Map<String, Document> availableDataServicesMap) {		
    	Map<String, List<String>> operationsMap = new HashMap<>();
    	Document dataserviceFile = availableDataServicesMap.get(getServiceName()); 
    	NodeList operationNodes = dataserviceFile.getElementsByTagName("operation");
    	for (int i = 0; i < operationNodes.getLength(); i++) {
    		Node operationNode = operationNodes.item(i);
    		List<String> paramList = new ArrayList<>();
    		Node callQueryNode = ((Element)operationNode).getElementsByTagName("call-query").item(0);
    		NodeList paramNodes = ((Element)callQueryNode).getElementsByTagName("with-param");
    		for (int j = 0; j < paramNodes.getLength(); j++) {
    			if (Node.ELEMENT_NODE == paramNodes.item(j).getNodeType()) {
	    			Element paramEle = (Element) paramNodes.item(j);
	    			paramList.add(paramEle.getAttribute("name"));  			
    			}
    		}
    		operationsMap.put(((Element)operationNode).getAttribute("name"), paramList);
    	}
    	return operationsMap ;
    }

	private String getServiceName() {
		return serviceName;
	}

	@Override
	public void refresh() {
	   super.refresh();
	   validate();
   }

   public void validate() {
       EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
       epv.clearElements(new Composite[] { propertiesGroup });
       //epv.showEntry(paramsElements, false);
       //epv.clearTableButtons(paramsElements);
       view.layout(true, true);
   }
	
	// End of user code


}
