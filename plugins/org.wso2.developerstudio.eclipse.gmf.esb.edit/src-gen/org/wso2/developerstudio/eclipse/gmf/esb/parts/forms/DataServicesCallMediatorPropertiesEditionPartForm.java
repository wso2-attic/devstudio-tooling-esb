/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSProjectArtifact;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class DataServicesCallMediatorPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DataServicesCallMediatorPropertiesEditionPart {

	protected Text description;
	protected Text commentsList;
	protected Button editCommentsList;
	protected EList commentsListList;
	protected Button reverse;
	protected EMFComboViewer sourceType;
	protected EMFComboViewer targetType;
	protected EMFComboViewer serviceName;

	protected EMFComboViewer operationType;
    protected ReferencesTable operations;
    protected List<ViewerFilter> operationsBusinessFilters = new ArrayList<ViewerFilter>();
    protected List<ViewerFilter> operationsFilters = new ArrayList<ViewerFilter>();
    protected Control[] availableDataServicesElements;
	protected Control[] availableOperationsElements;
	protected Control[] reverseElements;
    protected Control[] commentsElements;
	protected static String DS_NAME_DEFAULT_VALUE = "Select From Data Services";

	/**
	 * For {@link ISection} use only.
	 */
	public DataServicesCallMediatorPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DataServicesCallMediatorPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence dataServicesCallMediatorStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = dataServicesCallMediatorStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.serviceName);
		//propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.commentsList);
		//propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.reverse);
		propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType);
		propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.operationType);
		propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.operations);
		propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.targetType);
		propertiesStep.addStep(EsbViewsRepository.DataServicesCallMediator.Properties.description);
		
		composer = new PartComposer(dataServicesCallMediatorStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.serviceName) {
					return createServiceNameText(widgetFactory, parent);
				}
				/*if (key == EsbViewsRepository.DataServicesCallMediator.Properties.commentsList) {
					return createCommentsListMultiValuedEditor(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.reverse) {
					return createReverseCheckbox(widgetFactory, parent);
				}*/
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.sourceType) {
					return createSourceTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.operationType) {
					return createOperationTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.operations) {
					return createOperationsTableComposition(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.targetType) {
					return createTargetTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.DataServicesCallMediator.Properties.description) {
					return createDescriptionText(widgetFactory, parent);
				}

				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EsbMessages.DataServicesCallMediatorPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createDescriptionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServicesCallMediator.Properties.description, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_DescriptionLabel);
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
							DataServicesCallMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataServicesCallMediator.Properties.description,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServicesCallMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataServicesCallMediator.Properties.description,
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
									DataServicesCallMediatorPropertiesEditionPartForm.this,
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
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.description, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, description.getText()));
				}
			}
		});
		EditingUtils.setID(description, EsbViewsRepository.DataServicesCallMediator.Properties.description);
		EditingUtils.setEEFtype(description, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.description, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDescriptionText

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createCommentsListMultiValuedEditor(FormToolkit widgetFactory, Composite parent) {
		commentsList = widgetFactory.createText(parent, "", SWT.READ_ONLY); //$NON-NLS-1$
		GridData commentsListData = new GridData(GridData.FILL_HORIZONTAL);
		commentsListData.horizontalSpan = 2;
		commentsList.setLayoutData(commentsListData);
		EditingUtils.setID(commentsList, EsbViewsRepository.DataServicesCallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(commentsList, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editCommentsList = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DataServicesCallMediator.Properties.commentsList, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_CommentsListLabel), SWT.NONE);
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
						commentsList.getShell(), "DataServicesCallMediator", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						commentsListList, EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					commentsListList = dialog.getResult();
					if (commentsListList == null) {
						commentsListList = new BasicEList();
					}
					commentsList.setText(commentsListList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.commentsList, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(commentsListList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editCommentsList, EsbViewsRepository.DataServicesCallMediator.Properties.commentsList);
		EditingUtils.setEEFtype(editCommentsList, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		// Start of user code for createCommentsListMultiValuedEditor

		// End of user code
		return parent;
	}

	
	protected Composite createReverseCheckbox(FormToolkit widgetFactory, Composite parent) {
		reverse = widgetFactory.createButton(parent, getDescription(EsbViewsRepository.DataServicesCallMediator.Properties.reverse, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_ReverseLabel), SWT.CHECK);
		reverse.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.reverse, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(reverse.getSelection())));
			}

		});
		GridData reverseData = new GridData(GridData.FILL_HORIZONTAL);
		reverseData.horizontalSpan = 2;
		reverse.setLayoutData(reverseData);
		EditingUtils.setID(reverse, EsbViewsRepository.DataServicesCallMediator.Properties.reverse);
		EditingUtils.setEEFtype(reverse, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.reverse, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createReverseCheckbox

		// End of user code
		return parent;
	}

	
	protected Composite createSourceTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServicesCallMediator.Properties.sourceType, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_SourceTypeLabel);
		sourceType = new EMFComboViewer(parent);
		sourceType.setContentProvider(new ArrayContentProvider());
		sourceType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData sourceTypeData = new GridData(GridData.FILL_HORIZONTAL);
		sourceType.getCombo().setLayoutData(sourceTypeData);
		sourceType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.sourceType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSourceType()));
			}

		});
		sourceType.setID(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createSourceTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createTargetTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServicesCallMediator.Properties.targetType, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_TargetTypeLabel);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.targetType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTargetType()));
			}

		});
		targetType.setID(EsbViewsRepository.DataServicesCallMediator.Properties.targetType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.targetType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTargetTypeEMFComboViewer

		// End of user code
		return parent;
	}

	/**
     * @generated NOT
     */
	protected Composite createServiceNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.DataServicesCallMediator.Properties.serviceName, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_ServiceNameLabel);
		//serviceName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		serviceName = new EMFComboViewer(parent);
		serviceName.setContentProvider(new ArrayContentProvider());
		serviceName.setInput(getAvailableDataServicesListFromProject(parent));
		serviceName.getCombo().select(0);
		serviceName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData serviceNameData = new GridData(GridData.FILL_HORIZONTAL);
		
		serviceName.getCombo().setLayoutData(serviceNameData);
		serviceName.getCombo().addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
            public void handleEvent(Event arg0) {
                arg0.doit = false;
            }
        });
		EditingUtils.setID(serviceName.getCombo(), EsbViewsRepository.DataServicesCallMediator.Properties.serviceName);
		EditingUtils.setEEFtype(serviceName.getCombo(), "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.serviceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createAvailableDSNameText
		serviceName.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             *  
             */
            public void selectionChanged(SelectionChangedEvent event) {
            	if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.serviceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getServiceName()));
            	validate();
            }

        });
        // End of user code
		return parent;
		
		/*serviceName.setLayoutData(serviceNameData);
		serviceName.addFocusListener(new FocusAdapter() {
			*//**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 *//*
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DataServicesCallMediatorPropertiesEditionPartForm.this,
							EsbViewsRepository.DataServicesCallMediator.Properties.serviceName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServicesCallMediatorPropertiesEditionPartForm.this,
									EsbViewsRepository.DataServicesCallMediator.Properties.serviceName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, serviceName.getText()));
				}
			}

			*//**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 *//*
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DataServicesCallMediatorPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		serviceName.addKeyListener(new KeyAdapter() {
			*//**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 *//*
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.serviceName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, serviceName.getText()));
				}
			}
		});
		EditingUtils.setID(serviceName, EsbViewsRepository.DataServicesCallMediator.Properties.serviceName);
		EditingUtils.setEEFtype(serviceName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.serviceName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createServiceNameText

		// End of user code
		return parent;*/
	}

	protected Composite createOperationTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
    	Control operatioTypeLabel = createDescription(parent, EsbViewsRepository.DataServicesCallMediator.Properties.operationType, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_OperationTypeLabel);
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
              propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.operationType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getOperationType()));
          }

        });
        operationType.setID(EsbViewsRepository.DataServicesCallMediator.Properties.operationType);
        Control operationTypeHelp = FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.operationType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
        availableOperationsElements = new Control [] {operatioTypeLabel, operationType.getCombo(), operationTypeHelp};
        // Start of user code for createOperationTypeEMFComboViewer

        // End of user code
    
    return parent;
  }

  /**
   * @param container
   * 
   */
  protected Composite createOperationsTableComposition(FormToolkit widgetFactory, Composite parent) {
    this.operations = new ReferencesTable(getDescription(EsbViewsRepository.DataServicesCallMediator.Properties.operations, EsbMessages.DataServicesCallMediatorPropertiesEditionPart_OperationsLabel), new ReferencesTableListener() {
      public void handleAdd() {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
        operations.refresh();
      }
      public void handleEdit(EObject element) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
        operations.refresh();
      }
      public void handleMove(EObject element, int oldIndex, int newIndex) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
        operations.refresh();
      }
      public void handleRemove(EObject element) {
        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
        operations.refresh();
      }
      public void navigateTo(EObject element) { }
    });
    for (ViewerFilter filter : this.operationsFilters) {
      this.operations.addFilter(filter);
    }
    this.operations.setHelpText(propertiesEditionComponent.getHelpContent(EsbViewsRepository.DataServicesCallMediator.Properties.operations, EsbViewsRepository.FORM_KIND));
    this.operations.createControls(parent, widgetFactory);
    this.operations.addSelectionListener(new SelectionAdapter() {
      
      public void widgetSelected(SelectionEvent e) {
        if (e.item != null && e.item.getData() instanceof EObject) {
          propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DataServicesCallMediatorPropertiesEditionPartForm.this, EsbViewsRepository.DataServicesCallMediator.Properties.operations, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
        }
      }
      
    });
    GridData operationsData = new GridData(GridData.FILL_HORIZONTAL);
    operationsData.horizontalSpan = 3;
    this.operations.setLayoutData(operationsData);
    this.operations.setLowerBound(0);
    this.operations.setUpperBound(-1);
    operations.setID(EsbViewsRepository.DataServicesCallMediator.Properties.operations);
    operations.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
    // Start of user code for createOperationsTableComposition

    // End of user code
    return parent;
  }

  protected ArrayList<String> getAvailableDataServicesListFromProject(Composite parent) {

        String dssArtifcatCategory = "service/dataservice";
        String comboBoxDefaultValue = DS_NAME_DEFAULT_VALUE;
        ArrayList<String> availableList = new ArrayList<String>();
        availableList.add(comboBoxDefaultValue);
        File projectPath = null;
        final Shell shell = (Shell) parent.getShell();
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
                        projectPath = workspaceProject.getLocation().toFile();
                        try {
                        	dssProjectArtifact
                                    .fromFile(workspaceProject.getFile("artifact.xml").getLocation().toFile());
                            List<DSSArtifact> allDSSArtifacts = dssProjectArtifact.getAllDSSArtifacts();
                            for (DSSArtifact dssArtifact : allDSSArtifacts) {
                                if (dssArtifcatCategory.equals(dssArtifact.getType())) {
                                    File artifact = new File(projectPath, dssArtifact.getFile());
                                    availableList.add(artifact.getName().replaceAll("[.]dbs$", ""));
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
        return availableList;
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getDescription()
	 * 
	 */
	public String getDescription() {
		return description.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setDescription(String newValue)
	 * 
	 */
	public void setDescription(String newValue) {
		if (newValue != null) {
			description.setText(newValue);
		} else {
			description.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.description);
		if (eefElementEditorReadOnlyState && description.isEnabled()) {
			description.setEnabled(false);
			description.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !description.isEnabled()) {
			description.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getCommentsList()
	 * 
	 */
	public EList getCommentsList() {
		return commentsListList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setCommentsList(EList newValue)
	 * 
	 */
	public void setCommentsList(EList newValue) {
		commentsListList = newValue;
		if (newValue != null) {
			commentsList.setText(commentsListList.toString());
		} else {
			commentsList.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.commentsList);
		if (eefElementEditorReadOnlyState && commentsList.isEnabled()) {
			commentsList.setEnabled(false);
			commentsList.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getReverse()
	 * 
	 */
	public Boolean getReverse() {
		return Boolean.valueOf(reverse.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setReverse(Boolean newValue)
	 * 
	 */
	public void setReverse(Boolean newValue) {
		if (newValue != null) {
			reverse.setSelection(newValue.booleanValue());
		} else {
			reverse.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.reverse);
		if (eefElementEditorReadOnlyState && reverse.isEnabled()) {
			reverse.setEnabled(false);
			reverse.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !reverse.isEnabled()) {
			reverse.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getSourceType()
	 * 
	 */
	public Enumerator getSourceType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) sourceType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#initSourceType(Object input, Enumerator current)
	 */
	public void initSourceType(Object input, Enumerator current) {
		sourceType.setInput(input);
		sourceType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setSourceType(Enumerator newValue)
	 * 
	 */
	public void setSourceType(Enumerator newValue) {
		sourceType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType);
		if (eefElementEditorReadOnlyState && sourceType.isEnabled()) {
			sourceType.setEnabled(false);
			sourceType.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !sourceType.isEnabled()) {
			sourceType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getTargetType()
	 * 
	 */
	public Enumerator getTargetType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) targetType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#initTargetType(Object input, Enumerator current)
	 */
	public void initTargetType(Object input, Enumerator current) {
		targetType.setInput(input);
		targetType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setTargetType(Enumerator newValue)
	 * 
	 */
	public void setTargetType(Enumerator newValue) {
		targetType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.targetType);
		if (eefElementEditorReadOnlyState && targetType.isEnabled()) {
			targetType.setEnabled(false);
			targetType.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !targetType.isEnabled()) {
			targetType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getServiceName()
	 * 
	 */
	public String getServiceName() {
		return serviceName.getCombo().getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setServiceName(String newValue)
	 * 
	 */
	public void setServiceName(String newValue) {
		if (newValue != null) {
			serviceName.getCombo().setText(newValue);
		} else {
			serviceName.getCombo().setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.serviceName);
		if (eefElementEditorReadOnlyState && serviceName.isEnabled()) {
			serviceName.setEnabled(false);
			serviceName.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !serviceName.isEnabled()) {
			serviceName.setEnabled(true);
		}	
		
	}






	/**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#getOperationType()
   * 
   */
  public Enumerator getOperationType() {
    Enumerator selection = (Enumerator) ((StructuredSelection) operationType.getSelection()).getFirstElement();
    return selection;
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#initOperationType(Object input, Enumerator current)
   */
  public void initOperationType(Object input, Enumerator current) {
    operationType.setInput(input);
    operationType.modelUpdating(new StructuredSelection(current));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.operationType);
    if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
      operationType.setEnabled(false);
      operationType.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
      operationType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#setOperationType(Enumerator newValue)
   * 
   */
  public void setOperationType(Enumerator newValue) {
    operationType.modelUpdating(new StructuredSelection(newValue));
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.operationType);
    if (eefElementEditorReadOnlyState && operationType.isEnabled()) {
      operationType.setEnabled(false);
      operationType.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !operationType.isEnabled()) {
      operationType.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#initOperations(EObject current, EReference containingFeature, EReference feature)
   */
  public void initOperations(ReferencesTableSettings settings) {
    if (current.eResource() != null && current.eResource().getResourceSet() != null)
      this.resourceSet = current.eResource().getResourceSet();
    ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
    operations.setContentProvider(contentProvider);
    operations.setInput(settings);
    boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.DataServicesCallMediator.Properties.operations);
    if (eefElementEditorReadOnlyState && operations.isEnabled()) {
      operations.setEnabled(false);
      operations.setToolTipText(EsbMessages.DataServicesCallMediator_ReadOnly);
    } else if (!eefElementEditorReadOnlyState && !operations.isEnabled()) {
      operations.setEnabled(true);
    }	
    
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#updateOperations()
   * 
   */
  public void updateOperations() {
  operations.refresh();
}

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#addFilterOperations(ViewerFilter filter)
   * 
   */
  @Override
  public void addFilterToOperations(ViewerFilter filter) {
    operationsFilters.add(filter);
    if (this.operations != null) {
      this.operations.addFilter(filter);
    }
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#addBusinessFilterOperations(ViewerFilter filter)
   * 
   */
  @Override
  public void addBusinessFilterToOperations(ViewerFilter filter) {
    operationsBusinessFilters.add(filter);
  }

  /**
   * {@inheritDoc}
   * 
   * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart#isContainedInOperationsTable(EObject element)
   * 
   */
  @Override
  public boolean isContainedInOperationsTable(EObject element) {
    return ((ReferencesTableSettings)operations.getInput()).contains(element);
  }

  /**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.DataServicesCallMediator_Part_Title;
	}

	// Start of user code additional methods
	
	public void validate() {
        EEFPropertyViewUtil epv = new EEFPropertyViewUtil(view);
        //epv.hideEntry(commentsElements, false);
        //epv.hideEntry(reverseElements, false);
        
        if (getServiceName() != DS_NAME_DEFAULT_VALUE) {
        	epv.showEntry(availableOperationsElements, false);
        } else {
        	epv.hideEntry(availableOperationsElements, false);
        }
        view.layout(true, true);
    }
	
	// End of user code


}
