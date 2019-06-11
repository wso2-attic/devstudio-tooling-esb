/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.impl;

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

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.ParamPropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class ParamPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ParamPropertiesEditionPart {

	protected Text paramName;
	protected Text paramValue;



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
		propertiesStep.addStep(EsbViewsRepository.Param.Properties.paramValue);
		
		
		composer = new PartComposer(paramStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EsbViewsRepository.Param.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramName) {
					return createParamNameText(parent);
				}
				if (key == EsbViewsRepository.Param.Properties.paramValue) {
					return createParamValueText(parent);
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EsbMessages.Param_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
