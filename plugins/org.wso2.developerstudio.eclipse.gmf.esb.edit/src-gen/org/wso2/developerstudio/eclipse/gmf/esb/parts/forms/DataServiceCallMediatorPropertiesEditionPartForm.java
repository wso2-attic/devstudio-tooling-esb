/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.File;
import java.io.IOException;
// Start of user code for imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.jface.window.Window;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.impl.OperationPropertiesEditionPartImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;
import org.xml.sax.SAXException;

// End of user code

/**
 * 
 * @generated
 */
public class DataServiceCallMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DataServiceCallMediatorPropertiesEditionPart {

	// Start of user code additional methods
	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer dSName;
	protected EMFComboViewer operationType;
	protected EMFComboViewer operationName;
    protected ReferencesTable operations;
	protected List<ViewerFilter> operationsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> operationsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer targetType;
	protected Text propertyName;
	protected Control[] availableDataServicesElements;
	protected Control[] reverseElements;
    protected Control[] commentsElements;
    protected Control[] availableOperationTypesElements;
    protected Control[] availableOperationsElements;
    protected Control[] operationNameElements;
    protected Composite propertiesGroup;
    protected static String SINGLE_REQUEST = "SINGLE_REQUEST";
    protected static String BATCH_REQUEST = "BATCH_REQUEST";
    protected static String REQUEST_BOX = "REQUEST_BOX";
    protected static String DS_NAME_DEFAULT_VALUE = "Select From Data Services";
    protected static String OPERATION_TYPE_DEFAULT_VALUE = "Select From Operation Types";
    protected static String OPERATION_DEFAULT_VALUE = "Select From Operations";
    Map<String, Document> availableDataServicesMap = new HashMap<String, Document>();    
    // End of user code additional methods

	/**
	 * For {@link ISection} use only.
	 */
	public DataServiceCallMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataServiceCallMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence dataServiceCallMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dataServiceCallMediatorStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.commentsList);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.dSName);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.operationType);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.operationName);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.operations);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.targetType);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.propertyName);
		propertiesStep.addStep(EsbViewsRepository.DataServiceCallMediator.Properties.description);
		
		
		composer = new PartComposer(dataServiceCallMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.dSName) {
					return createDSNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.operationType) {
					return createOperationTypeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.operationName) {
					return createOperationNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.operations) {
					return createOperationsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.targetType) {
					return createTargetTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServiceCallMediator.Properties.propertyName) {
					return createPropertyNameText(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
     * @generated NOT
     */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.DataServiceCallMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServiceCallMediator.Properties.description, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_DescriptionLabel);
		description = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		description.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData descriptionData = new GridData(GridData.FILL_HORIZONTAL);
		description.setLayoutData(descriptionData);
		description.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DataServiceCallMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataServiceCallMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServiceCallMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataServiceCallMediator.Properties.description,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, description.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServiceCallMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		description.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.DataServiceCallMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		Control [] previousControls = propertiesGroup.getChildren();
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DataServiceCallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DataServiceCallMediator.Properties.commentsList, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
		GridData editCommentsListData = new GridData();
		editCommentsList.setLayoutData(editCommentsListData);
		editCommentsList.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						commentsList.getShell(), "DataServiceCallMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DataServiceCallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor
		Control [] newControls = propertiesGroup.getChildren();
		commentsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		Control [] previousControls = propertiesGroup.getChildren();
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DataServiceCallMediator.Properties.reverse, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DataServiceCallMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox
		Control [] newControls = propertiesGroup.getChildren();
        reverseElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createDSNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServiceCallMediator.Properties.dSName, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_DSNameLabel);
		
		dSName = new EMFComboViewer(parent);
		dSName.setContentProvider(new ArrayContentProvider());
		availableDataServicesMap = DataServiceCallMediatorPropertiesUtil.getAvailableDataServicesListFromProject(parent);
		List <String> availableDataServicesList = new ArrayList<>();
		availableDataServicesList.add(DS_NAME_DEFAULT_VALUE);
		availableDataServicesList.addAll(availableDataServicesMap.keySet());
		dSName.setInput(availableDataServicesList);
		dSName.getCombo().select(0);
		dSName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData dSNameData = new GridData(GridData.FILL_HORIZONTAL);
		dSName.getCombo().setLayoutData(dSNameData);
		dSName.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
		EditingUtils.setID(dSName.getCombo(), EsbViewsRepository.DataServiceCallMediator.Properties.dSName);
		EditingUtils.setEEFtype(dSName.getCombo(), "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.dSName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableDSNameText
		dSName.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
            	propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.dSName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.CHANGE, null, dSName.getCombo().getText()));
            	loadSupportedOperationTypes();
            	refresh();
            }

        });
        // End of user code
		return parent;
	}
	
	/**
     * @generated NOT
     */
	protected Composite createOperationTypeText(FormToolkit widgetFactory, Composite parent) {
		Control operatioTypeLabel = createDescription(parent, EsbViewsRepository.DataServiceCallMediator.Properties.operationType, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_OperationTypeLabel);
		operationType = new EMFComboViewer(parent);
		operationType.setContentProvider(new ArrayContentProvider());
		operationType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData operationTypeData = new GridData(GridData.FILL_HORIZONTAL);
		operationType.getCombo().setLayoutData(operationTypeData);
		operationType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operationType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOperationType()));
				 refresh();
			}

		});
		operationType.setID(EsbViewsRepository.DataServiceCallMediator.Properties.operationType);
		Control operationTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.operationType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		availableOperationTypesElements = new Control [] {operatioTypeLabel, operationType.getCombo(), operationTypeHelp};
		// Start of user code for createOperationTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createOperationNameText(FormToolkit widgetFactory, Composite parent) {
		Control operatioNameLabel = createDescription(parent, EsbViewsRepository.DataServiceCallMediator.Properties.operationName, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_OperationNameLabel);
        operationName = new EMFComboViewer(parent);
        operationName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        operationName.setContentProvider(new ArrayContentProvider());
        operationName.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData operationTypeData = new GridData(GridData.FILL_HORIZONTAL);
		operationName.getCombo().setLayoutData(operationTypeData);
		operationName.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operationName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOperationName()));
					operations.refresh();
				}
			}

		});
		operationName.setID(EsbViewsRepository.DataServiceCallMediator.Properties.operationType);
        Control operationNameHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.operationName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        // Start of user code for createOperationNameText
        operationNameElements = new Control [] {operatioNameLabel, operationName.getCombo(), operationNameHelp};
        // End of user code
        return parent;
  }

	/**
     * @generated NOT
     */
	protected Composite createOperationsTableComposition(FormToolkit widgetFactory, Composite parent) {
		Control[] previousControls = propertiesGroup.getChildren();
		this.operations = new ReferencesTable(getDescription(EsbViewsRepository.DataServiceCallMediator.Properties.operations, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_OperationsLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				operations.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				operations.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				operations.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				operations.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.operationsFilters) {
			this.operations.addFilter(filter);
		}
		this.operations.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.operations, EsbViewsRepository.FORM_KIND));
		this.operations.createControls(parent, widgetFactory);
		this.operations.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.operations, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData operationsData = new GridData(GridData.FILL_HORIZONTAL);
		operationsData.horizontalSpan = 3;
		this.operations.setLayoutData(operationsData);
		this.operations.setLowerBound(0);
		this.operations.setUpperBound(-1);
		operations.setID(EsbViewsRepository.DataServiceCallMediator.Properties.operations);
		operations.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createOperationsTableComposition
        Control[] newControls = propertiesGroup.getChildren();
        availableOperationsElements = EEFPropertyViewUtil.getTableElements(previousControls, newControls);
		// End of user code
		return parent;
	}

	
	protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServiceCallMediator.Properties.targetType, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_TargetTypeLabel);
		targetType = new EMFComboViewer(parent);
		targetType.setContentProvider(new ArrayContentProvider());
		targetType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData targetTypeData = new GridData(GridData.FILL_HORIZONTAL);
		targetType.getCombo().setLayoutData(targetTypeData);
		targetType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.DataServiceCallMediator.Properties.targetType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.targetType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createPropertyNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServiceCallMediator.Properties.propertyName, EsbMessages.DataServiceCallMediatorPropertiesEditionPart_PropertyNameLabel);
		propertyName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		propertyName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData propertyNameData = new GridData(GridData.FILL_HORIZONTAL);
		propertyName.setLayoutData(propertyNameData);
		propertyName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DataServiceCallMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataServiceCallMediator.Properties.propertyName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServiceCallMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataServiceCallMediator.Properties.propertyName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, propertyName.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServiceCallMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		propertyName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServiceCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServiceCallMediator.Properties.propertyName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, propertyName.getText()));
				}
			}
		});
		EditingUtils.setID(propertyName, EsbViewsRepository.DataServiceCallMediator.Properties.propertyName);
		EditingUtils.setEEFtype(propertyName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServiceCallMediator.Properties.propertyName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPropertyNameText

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !commentsList.isEnabled()) {
			commentsList.setEnabled(true);
		}	
		
	}

	public void addToCommentsList(Object newValue) {
		commentsListList.add(newValue);
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToCommentsList(Object newValue) {
		commentsListList.remove(newValue);
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#getDSName()
	 * 
	 */
	public String getDSName() {
		return dSName.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setDSName(String newValue)
	 * 
	 */
	public void setDSName(String newValue) {
		if (newValue != null) {
			dSName.getCombo().setText(newValue);
		} else {
			dSName.getCombo().setText(""); //$NON-NLS-1$
		}		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setOperationType(Enumerator newValue)
	 * 
	 */
	public void setOperationType(Enumerator newValue) {
		operationType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.operationType);
		if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
			operationType.setEnabled(false);
			operationType.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
			operationType.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#initOperations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOperations(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		operations.setContentProvider(contentProvider);
		operations.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.operations);
		if (eefElementEditorReadOnlyState && operations.isEnabled()) {
			operations.setEnabled(false);
			operations.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !operations.isEnabled()) {
			operations.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#updateOperations()
	 * 
	 */
	public void updateOperations() {
	operations.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#addFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter) {
		operationsFilters.add(filter);
		if (this.operations != null) {
			this.operations.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#addBusinessFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter) {
		operationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#isContainedInOperationsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element) {
		return ((ReferencesTableSettings)operations.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#getPropertyName()
	 * 
	 */
	public String getPropertyName() {
		return propertyName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart#setPropertyName(String newValue)
	 * 
	 */
	public void setPropertyName(String newValue) {
		if (newValue != null) {
			propertyName.setText(newValue);
		} else {
			propertyName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServiceCallMediator.Properties.propertyName);
		if (eefElementEditorReadOnlyState && propertyName.isEnabled()) {
			propertyName.setEnabled(false);
			propertyName.setToolTipText(EsbMessages.DataServiceCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !propertyName.isEnabled()) {
			propertyName.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DataServiceCallMediator_Part_Title;
	}

    // Start of user code additional methods
    @Override
    public void refresh() {
        super.refresh();
        validate();
    }

    public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        epv.hideEntry(commentsElements, false);
        epv.hideEntry(reverseElements, false);
        
        if (getDSName() != DS_NAME_DEFAULT_VALUE) {
        	epv.showEntry(availableOperationTypesElements, false);
        	if (!operationType.getCombo().getText().equals(REQUEST_BOX)) {
        		loadAvailableOperations();
        		epv.showEntry(operationNameElements, false);
                EEFPropertyViewUtil propertyView = new EEFPropertyViewUtil(view);
        		propertyView.clearTableButtons(availableOperationsElements);
        	} else {
        		epv.hideEntry(operationNameElements, false);
        		EEFPropertyViewUtil propertyView = new EEFPropertyViewUtil(view);
        		propertyView.showTableButtons(availableOperationsElements);
        	}
        	epv.showEntry(availableOperationsElements, false);
        } else {
        	epv.hideEntry(availableOperationTypesElements, false);
        	epv.hideEntry(operationNameElements, false);
        	epv.hideEntry(availableOperationsElements, false);
        }
        view.layout(true, true);
    }

    protected void loadSupportedOperationTypes() {
    	if (Arrays.asList(operationType.getCombo().getItems()).contains(BATCH_REQUEST)) {
    		operationType.getCombo().remove(BATCH_REQUEST);
    	}
    	if (Arrays.asList(operationType.getCombo().getItems()).contains(REQUEST_BOX)) {
    		operationType.getCombo().remove(REQUEST_BOX);
    	}
    	if (Arrays.asList(operationType.getCombo().getItems()).contains(SINGLE_REQUEST)) {
    		operationType.getCombo().remove(SINGLE_REQUEST);
    	}
		operationType.getCombo().add(OPERATION_TYPE_DEFAULT_VALUE);
		operationType.getCombo().setText(OPERATION_TYPE_DEFAULT_VALUE);
		operationType.getCombo().add(SINGLE_REQUEST);
    	if (getDSName() != DS_NAME_DEFAULT_VALUE) {
        	Document dataserviceFile = availableDataServicesMap.get(getDSName());   	
    		String enableBoxCar = dataserviceFile.getDocumentElement().getAttribute("enableBoxcarring");
    		if ("true".equals(enableBoxCar)) {
    			operationType.getCombo().add(REQUEST_BOX);
    		}
    		String batchReq = dataserviceFile.getDocumentElement().getAttribute("enableBatchRequests");
    		if ("true".equals(batchReq)) {
    			operationType.getCombo().add(BATCH_REQUEST);
    		}
    	}
    }
    
    protected void loadAvailableOperations() {
    	operationName.getCombo().removeAll();
		operationName.getCombo().add(OPERATION_DEFAULT_VALUE);
    	operationName.getCombo().setText(OPERATION_DEFAULT_VALUE);
    	Document dataserviceFile = availableDataServicesMap.get(getDSName()); 
    	NodeList operationNodes = dataserviceFile.getElementsByTagName("operation");
    	for (int i = 0; i < operationNodes.getLength(); i++) {
    		Node operationNode = operationNodes.item(i);
    		operationName.getCombo().add(((Element)operationNode).getAttribute("name"));
    	}
    }
    
    
    // End of user code

	@Override
	public String getOperationName() {
		return operationName.getCombo().getText();
	}

	@Override
	public void setOperationName(String newValue) {
		if (newValue != null) {
			operationName.getCombo().setText(newValue);
		} else {
			operationName.getCombo().setText(""); //$NON-NLS-1$
		}		
	}

	@Override
	public String getOperationType() {
		return operationType.getCombo().getText();
	}

	@Override
	public void setOperationType(String newValue) {
		if (newValue != null) {
			operationType.getCombo().setText(newValue);
		} else {
			operationType.getCombo().setText(""); //$NON-NLS-1$
		}		
	}


}
