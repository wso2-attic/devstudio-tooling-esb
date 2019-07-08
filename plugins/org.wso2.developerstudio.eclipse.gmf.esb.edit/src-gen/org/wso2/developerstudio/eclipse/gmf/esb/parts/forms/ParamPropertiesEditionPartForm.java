/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
// Start of user code for imports
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
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ParamPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ParamPropertiesEditionPart {

	protected Text paramName;
	protected Text type;
	protected EMFComboViewer paramValueType;
	protected Text paramValue;
	protected EMFComboViewer evauator;
	// Start of user code  for ExpressionView widgets declarations
	
	// End of user code




	/**
	 * For {@link ISection} use only.
	 */
	public ParamPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ParamPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence paramStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = paramStep.addStep(EsbViewsRepository.Param.Properties.class);
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.paramName);
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.type);
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.paramValueType);
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.paramValue);
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.evauator);
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.expressionView);
		
		
		composer = new PartComposer(paramStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Param.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramName) {
					return createParamNameText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Param.Properties.type) {
					return createTypeText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramValueType) {
					return createParamValueTypeEMFComboViewer(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramValue) {
					return createParamValueText(widgetFactory, parent);
				}
				if (key == EsbViewsRepository.Param.Properties.evauator) {
					return createEvauatorEMFComboViewer(widgetFactory, parent);
				}
				// Start of user code for ExpressionView addToPart creation
				
				// End of user code
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
		propertiesSection.setText(EsbMessages.ParamPropertiesEditionPart_PropertiesGroupLabel);
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

	
	protected Composite createParamNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.paramName, EsbMessages.ParamPropertiesEditionPart_ParamNameLabel);
		paramName = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		paramName.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData paramNameData = new GridData(GridData.FILL_HORIZONTAL);
		paramName.setLayoutData(paramNameData);
		paramName.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ParamPropertiesEditionPartForm.this,
							EsbViewsRepository.Param.Properties.paramName,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramName.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParamPropertiesEditionPartForm.this,
									EsbViewsRepository.Param.Properties.paramName,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, paramName.getText()));
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
									ParamPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		paramName.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartForm.this, EsbViewsRepository.Param.Properties.paramName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramName.getText()));
				}
			}
		});
		EditingUtils.setID(paramName, EsbViewsRepository.Param.Properties.paramName);
		EditingUtils.setEEFtype(paramName, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.paramName, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParamNameText

		// End of user code
		return parent;
	}

	
	protected Composite createTypeText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.type, EsbMessages.ParamPropertiesEditionPart_TypeLabel);
		type = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		type.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ParamPropertiesEditionPartForm.this,
							EsbViewsRepository.Param.Properties.type,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParamPropertiesEditionPartForm.this,
									EsbViewsRepository.Param.Properties.type,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, type.getText()));
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
									ParamPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		type.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartForm.this, EsbViewsRepository.Param.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
				}
			}
		});
		EditingUtils.setID(type, EsbViewsRepository.Param.Properties.type);
		EditingUtils.setEEFtype(type, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.type, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createTypeText

		// End of user code
		return parent;
	}

	
	protected Composite createParamValueTypeEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.paramValueType, EsbMessages.ParamPropertiesEditionPart_ParamValueTypeLabel);
		paramValueType = new EMFComboViewer(parent);
		paramValueType.setContentProvider(new ArrayContentProvider());
		paramValueType.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData paramValueTypeData = new GridData(GridData.FILL_HORIZONTAL);
		paramValueType.getCombo().setLayoutData(paramValueTypeData);
		paramValueType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartForm.this, EsbViewsRepository.Param.Properties.paramValueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParamValueType()));
			}

		});
		paramValueType.setID(EsbViewsRepository.Param.Properties.paramValueType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.paramValueType, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParamValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createParamValueText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.paramValue, EsbMessages.ParamPropertiesEditionPart_ParamValueLabel);
		paramValue = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		paramValue.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData paramValueData = new GridData(GridData.FILL_HORIZONTAL);
		paramValue.setLayoutData(paramValueData);
		paramValue.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ParamPropertiesEditionPartForm.this,
							EsbViewsRepository.Param.Properties.paramValue,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramValue.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ParamPropertiesEditionPartForm.this,
									EsbViewsRepository.Param.Properties.paramValue,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, paramValue.getText()));
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
									ParamPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		paramValue.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartForm.this, EsbViewsRepository.Param.Properties.paramValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramValue.getText()));
				}
			}
		});
		EditingUtils.setID(paramValue, EsbViewsRepository.Param.Properties.paramValue);
		EditingUtils.setEEFtype(paramValue, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.paramValue, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createParamValueText

		// End of user code
		return parent;
	}

	
	protected Composite createEvauatorEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.evauator, EsbMessages.ParamPropertiesEditionPart_EvauatorLabel);
		evauator = new EMFComboViewer(parent);
		evauator.setContentProvider(new ArrayContentProvider());
		evauator.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData evauatorData = new GridData(GridData.FILL_HORIZONTAL);
		evauator.getCombo().setLayoutData(evauatorData);
		evauator.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartForm.this, EsbViewsRepository.Param.Properties.evauator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEvauator()));
			}

		});
		evauator.setID(EsbViewsRepository.Param.Properties.evauator);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.evauator, EsbViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEvauatorEMFComboViewer

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
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#getParamName()
	 * 
	 */
	public String getParamName() {
		return paramName.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#setParamName(String newValue)
	 * 
	 */
	public void setParamName(String newValue) {
		if (newValue != null) {
			paramName.setText(newValue);
		} else {
			paramName.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.paramName);
		if (eefElementEditorReadOnlyState && paramName.isEnabled()) {
			paramName.setEnabled(false);
			paramName.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !paramName.isEnabled()) {
			paramName.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#getType()
	 * 
	 */
	public String getType() {
		return type.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#setType(String newValue)
	 * 
	 */
	public void setType(String newValue) {
		if (newValue != null) {
			type.setText(newValue);
		} else {
			type.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.type);
		if (eefElementEditorReadOnlyState && type.isEnabled()) {
			type.setEnabled(false);
			type.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !type.isEnabled()) {
			type.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#getParamValueType()
	 * 
	 */
	public Enumerator getParamValueType() {
		Enumerator selection = (Enumerator) ((StructuredSelection) paramValueType.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#initParamValueType(Object input, Enumerator current)
	 */
	public void initParamValueType(Object input, Enumerator current) {
		paramValueType.setInput(input);
		paramValueType.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.paramValueType);
		if (eefElementEditorReadOnlyState && paramValueType.isEnabled()) {
			paramValueType.setEnabled(false);
			paramValueType.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !paramValueType.isEnabled()) {
			paramValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#setParamValueType(Enumerator newValue)
	 * 
	 */
	public void setParamValueType(Enumerator newValue) {
		paramValueType.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.paramValueType);
		if (eefElementEditorReadOnlyState && paramValueType.isEnabled()) {
			paramValueType.setEnabled(false);
			paramValueType.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !paramValueType.isEnabled()) {
			paramValueType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#getParamValue()
	 * 
	 */
	public String getParamValue() {
		return paramValue.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#setParamValue(String newValue)
	 * 
	 */
	public void setParamValue(String newValue) {
		if (newValue != null) {
			paramValue.setText(newValue);
		} else {
			paramValue.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.paramValue);
		if (eefElementEditorReadOnlyState && paramValue.isEnabled()) {
			paramValue.setEnabled(false);
			paramValue.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !paramValue.isEnabled()) {
			paramValue.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#getEvauator()
	 * 
	 */
	public Enumerator getEvauator() {
		Enumerator selection = (Enumerator) ((StructuredSelection) evauator.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#initEvauator(Object input, Enumerator current)
	 */
	public void initEvauator(Object input, Enumerator current) {
		evauator.setInput(input);
		evauator.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.evauator);
		if (eefElementEditorReadOnlyState && evauator.isEnabled()) {
			evauator.setEnabled(false);
			evauator.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evauator.isEnabled()) {
			evauator.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart#setEvauator(Enumerator newValue)
	 * 
	 */
	public void setEvauator(Enumerator newValue) {
		evauator.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.Param.Properties.evauator);
		if (eefElementEditorReadOnlyState && evauator.isEnabled()) {
			evauator.setEnabled(false);
			evauator.setToolTipText(EsbMessages.Param_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !evauator.isEnabled()) {
			evauator.setEnabled(true);
		}	
		
	}






	// Start of user code for ExpressionView specific getters and setters implementation
	
	// End of user code

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.Param_Part_Title;
	}

	@Override
	public void setParamExpression(NamespacedProperty namespacedProperty) {
		
	}

	@Override
	public NamespacedProperty getParamExpression() {
		return null;
	}

	// Start of user code additional methods
	
	// End of user code


}
