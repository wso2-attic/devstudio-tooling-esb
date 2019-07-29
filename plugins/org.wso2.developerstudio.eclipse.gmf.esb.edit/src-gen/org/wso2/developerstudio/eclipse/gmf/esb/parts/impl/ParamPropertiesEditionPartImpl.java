/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFNameSpacedPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ParamPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ParamPropertiesEditionPart {

	protected Text paramName;
	protected Text type;
	protected EMFComboViewer paramValueType;
	protected Text paramValue;
	protected EMFComboViewer evauator;
	// Start of user code  for ExpressionView widgets declarations
	protected NamespacedProperty paramExpression;
	protected Text paramExpressionText;
	// End of user code




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ParamPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
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
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramName) {
					return createParamNameText(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.type) {
					return createTypeText(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramValueType) {
					return createParamValueTypeEMFComboViewer(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramValue) {
					return createParamValueText(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.evauator) {
					return createEvauatorEMFComboViewer(parent);
				}
				// Start of user code for ExpressionView addToPart creation
				if (key == EsbViewsRepository.Param.Properties.expressionView) {
					return createParamExpression(parent);
				}
				// End of user code
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EsbMessages.ParamPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	
	protected Composite createParamNameText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.paramName, EsbMessages.ParamPropertiesEditionPart_ParamNameLabel);
		paramName = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData paramNameData = new GridData(GridData.FILL_HORIZONTAL);
		paramName.setLayoutData(paramNameData);
		paramName.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.paramName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramName.getText()));
			}

		});
		paramName.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.paramName, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramName.getText()));
				}
			}

		});
		EditingUtils.setID(paramName, EsbViewsRepository.Param.Properties.paramName);
		EditingUtils.setEEFtype(paramName, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.paramName, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParamNameText

		// End of user code
		return parent;
	}

	
	protected Composite createTypeText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.type, EsbMessages.ParamPropertiesEditionPart_TypeLabel);
		type = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData typeData = new GridData(GridData.FILL_HORIZONTAL);
		type.setLayoutData(typeData);
		type.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
			}

		});
		type.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.type, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, type.getText()));
				}
			}

		});
		EditingUtils.setID(type, EsbViewsRepository.Param.Properties.type);
		EditingUtils.setEEFtype(type, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.type, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createTypeText

		// End of user code
		return parent;
	}

	
	protected Composite createParamValueTypeEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.paramValueType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParamValueType()));
			}

		});
		paramValueType.setID(EsbViewsRepository.Param.Properties.paramValueType);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.paramValueType, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParamValueTypeEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createParamValueText(Composite parent) {
		createDescription(parent, EsbViewsRepository.Param.Properties.paramValue, EsbMessages.ParamPropertiesEditionPart_ParamValueLabel);
		paramValue = SWTUtils.createScrollableText(parent, SWT.BORDER);
		GridData paramValueData = new GridData(GridData.FILL_HORIZONTAL);
		paramValue.setLayoutData(paramValueData);
		paramValue.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.paramValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramValue.getText()));
			}

		});
		paramValue.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.paramValue, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, paramValue.getText()));
				}
			}

		});
		EditingUtils.setID(paramValue, EsbViewsRepository.Param.Properties.paramValue);
		EditingUtils.setEEFtype(paramValue, "eef::Text"); //$NON-NLS-1$
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.paramValue, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createParamValueText

		// End of user code
		return parent;
	}
	
	/*
	 * generated NOT
	 */
	protected Composite createParamExpression(final Composite parent) {
		Control paramExpressionLabel = createDescription(parent, EsbViewsRepository.Param.Properties.expressionView, EsbMessages.ParamExpressionPropertiesEditionPart_ParamExpressionLabel);

        if (paramExpression == null) {
        	paramExpression = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
        }
        
        paramExpressionText = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
        GridData valueData = new GridData(GridData.FILL_HORIZONTAL);
        paramExpressionText.setLayoutData(valueData);
        paramExpressionText.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				EEFNameSpacedPropertyEditorDialog nspd = new EEFNameSpacedPropertyEditorDialog(parent.getShell(), SWT.NULL, paramExpression);
                nspd.open();
                paramExpressionText.setText(paramExpression.getPropertyValue());
                propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, 
                		EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getParamExpression()));
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

        EditingUtils.setID(paramExpressionText, EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression);
        EditingUtils.setEEFtype(paramExpressionText, "eef::Text");
        Control paramExpressionHelp = SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.PayloadFactoryArgument.Properties.argumentExpression, EsbViewsRepository.SWT_KIND), null);
//        paramExpressionElements = new Control[] {argumentExpressionLabel, argumentExpressionText, argumentExpressionHelp};
        return parent;

	}

	
	protected Composite createEvauatorEMFComboViewer(Composite parent) {
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ParamPropertiesEditionPartImpl.this, EsbViewsRepository.Param.Properties.evauator, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getEvauator()));
			}

		});
		evauator.setID(EsbViewsRepository.Param.Properties.evauator);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EsbViewsRepository.Param.Properties.evauator, EsbViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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

	// Start of user code additional methods
	@Override
	public void setParamExpression(NamespacedProperty namespacedProperty) {
		if (namespacedProperty != null) {
			paramExpression = namespacedProperty;
			paramExpressionText.setText(namespacedProperty.getPropertyValue());
		}
	}

	@Override
	public NamespacedProperty getParamExpression() {
		return paramExpression;
	}
	
	// End of user code


}
