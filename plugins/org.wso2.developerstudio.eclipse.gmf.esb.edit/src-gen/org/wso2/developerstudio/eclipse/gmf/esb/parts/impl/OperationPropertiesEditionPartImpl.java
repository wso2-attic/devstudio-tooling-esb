/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.DataServiceCallMediatorPropertiesEditionPartForm;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.DataServiceCallMediatorPropertiesUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class OperationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, OperationPropertiesEditionPart {

	protected EMFComboViewer operationName;
	protected ReferencesTable params;
	protected List<ViewerFilter> paramsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> paramsFilters = new ArrayList<ViewerFilter>();
	Map<String, Document> availableDataServicesMap;
	private String dsName;
	private String opName; 
	protected Control[] paramsElements;
	protected Group propertiesGroup;
	protected static String OPERATION_DEFAULT_VALUE = "Select From Operations";



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public OperationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
		if (editionComponent.getEditingContext() != null && editionComponent.getEditingContext().getEObject() != null && 
				editionComponent.getEditingContext().getEObject().eContainer() != null && editionComponent.getEditingContext().getEObject().eContainer() 
				instanceof DataServiceCallMediatorImpl) {
			dsName = ((DataServiceCallMediatorImpl)editionComponent.getEditingContext().getEObject().eContainer()).getDSName();
			opName = ((DataServiceCallMediatorImpl)editionComponent.getEditingContext().getEObject().eContainer()).getOperationName();
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
		CompositionSequence operationStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = operationStep.addStep(EsbViewsRepository.Operation.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.Operation.Properties.operationName);
		propertiesStep.addStep(EsbViewsRepository.Operation.Properties.params);
		
		
		composer = new PartComposer(operationStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Operation.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.Operation.Properties.operationName) {
					return createOperationNameText(parent);
				}
				if (key == EsbViewsRepository.Operation.Properties.params) {
					return createParamsAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(Composite parent) {
		propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.OperationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
     * @generated NOT
     */
	protected Composite createOperationNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Operation.Properties.operationName, EsbMessages.OperationPropertiesEditionPart_OperationNameLabel);
		operationName = new EMFComboViewer(parent);
		operationName.setContentProvider(new ArrayContentProvider());
		GridData operationNameData = new GridData(GridData.FILL_HORIZONTAL);
		Map<String, Document> currentDataServicesMap = DataServiceCallMediatorPropertiesUtil.getAvailableDataServicesListFromProject(parent);
		if (!currentDataServicesMap.isEmpty()) {
			availableDataServicesMap = currentDataServicesMap;
		}
		Map<String, List<String>> operationsMap = getAllAvailableOperations(getDsName(), availableDataServicesMap);
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
		EditingUtils.setID(operationName.getCombo(), EsbViewsRepository.Operation.Properties.operationName);
		EditingUtils.setEEFtype(operationName.getCombo(), "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Operation.Properties.operationName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createOperationNameText
		operationName.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
            	propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.CHANGE, operationsMap.get(operationName.getCombo().getText()), operationName.getCombo().getText()));
            	params.refresh();
            }

        });
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createParamsAdvancedTableComposition(Composite parent) {
		Control[] previousControls = propertiesGroup.getChildren();
		this.params = new ReferencesTable(getDescription(EsbViewsRepository.Operation.Properties.params, EsbMessages.OperationPropertiesEditionPart_ParamsLabel), new ReferencesTableListener() {
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.params, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				params.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.params, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				params.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.params, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				params.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.params, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				params.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.paramsFilters) {
			this.params.addFilter(filter);
		}
		this.params.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.Operation.Properties.params, EsbViewsRepository.SWT_KIND));
		this.params.createControls(parent);
		this.params.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OperationPropertiesEditionPartImpl.this, EsbViewsRepository.Operation.Properties.params, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData paramsData = new GridData(GridData.FILL_HORIZONTAL);
		paramsData.horizontalSpan = 3;
		this.params.setLayoutData(paramsData);
		this.params.setLowerBound(0);
		this.params.setUpperBound(-1);
		params.setID(EsbViewsRepository.Operation.Properties.params);
		params.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createParamsAdvancedTableComposition
		Control[] newControls = propertiesGroup.getChildren();
		paramsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		EEFPropertyViewUtil propertyView = new EEFPropertyViewUtil(view);
//		propertyView.clearTableButtons(paramsElements);
		// End of user code
		return parent;
	}


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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#getOperationName()
	 * 
	 */
	public String getOperationName() {
		return operationName.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#setOperationName(String newValue)
	 * 
	 */
	public void setOperationName(String newValue) {
		if (newValue != null) {
			operationName.getCombo().setText(newValue);
		} else {
			operationName.getCombo().setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Operation.Properties.operationName);
		if (eefElementEditorReadOnlyState && operationName.isEnabled()) {
			operationName.setEnabled(false);
			operationName.setToolTipText(EsbMessages.Operation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationName.isEnabled()) {
			operationName.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#initParams(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initParams(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		params.setContentProvider(contentProvider);
		params.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Operation.Properties.params);
		if (eefElementEditorReadOnlyState && params.isEnabled()) {
			params.setEnabled(false);
			params.setToolTipText(EsbMessages.Operation_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !params.isEnabled()) {
			params.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#updateParams()
	 * 
	 */
	public void updateParams() {
	params.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#addFilterParams(ViewerFilter filter)
	 * 
	 */
	public void addFilterToParams(ViewerFilter filter) {
		paramsFilters.add(filter);
		if (this.params != null) {
			this.params.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#addBusinessFilterParams(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParams(ViewerFilter filter) {
		paramsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.OperationPropertiesEditionPart#isContainedInParamsTable(EObject element)
	 * 
	 */
	public boolean isContainedInParamsTable(EObject element) {
		return ((ReferencesTableSettings)params.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.Operation_Part_Title;
	}

	// Start of user code additional methods
	
	protected Map<String, List<String>> getAllAvailableOperations(String DSName, Map<String, Document> availableDataServicesMap) {		
    	Map<String, List<String>> operationsMap = new HashMap<>();
    	Document dataserviceFile = availableDataServicesMap.get(getDsName()); 
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

	private String getDsName() {
		return dsName;
	}
	
	@Override
	public void refresh() {
	   super.refresh();
	   validate();
   }
	
   public void validate() {
       EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
       epv.clearElements(new Composite[] { propertiesGroup });
       epv.showEntry(paramsElements, false);
//       epv.clearTableButtons(paramsElements);
       view.layout(true, true);
   }
	// End of user code


}
