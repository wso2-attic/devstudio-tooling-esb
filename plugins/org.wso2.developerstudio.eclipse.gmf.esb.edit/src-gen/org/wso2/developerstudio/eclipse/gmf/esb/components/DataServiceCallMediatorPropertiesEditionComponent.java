/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Operation;
import org.wso2.developerstudio.eclipse.gmf.esb.OperationType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.OperationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServiceCallMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.forms.DataServiceCallMediatorPropertiesEditionPartForm;


// End of user code

/**
 * 
 * 
 */
public class DataServiceCallMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for Operations ReferencesTable
	 */
	protected ReferencesTableSettings operationsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public DataServiceCallMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dataServiceCallMediator, String editing_mode) {
		super(editingContext, dataServiceCallMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DataServiceCallMediator.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final DataServiceCallMediator dataServiceCallMediator = (DataServiceCallMediator)elt;
			final DataServiceCallMediatorPropertiesEditionPart basePart = (DataServiceCallMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServiceCallMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.commentsList))
				basePart.setCommentsList(dataServiceCallMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.reverse)) {
				basePart.setReverse(dataServiceCallMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.dSName))
				basePart.setDSName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServiceCallMediator.getDSName()));
			
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operationType))
				basePart.setOperationType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServiceCallMediator.getOperationType()));
			
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operationName))
				basePart.setOperationName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServiceCallMediator.getOperationName()));
			
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operations)) {
				operationsSettings = new ReferencesTableSettings(dataServiceCallMediator, EsbPackage.eINSTANCE.getDataServiceCallMediator_Operations());
				basePart.initOperations(operationsSettings);
			}
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.targetType)) {
				basePart.initTargetType(EEFUtils.choiceOfValues(dataServiceCallMediator, EsbPackage.eINSTANCE.getDataServiceCallMediator_TargetType()), dataServiceCallMediator.getTargetType());
			}
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.propertyName))
				basePart.setPropertyName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServiceCallMediator.getPropertyName()));
			
			// init filters
			
			
			
			
			
			
			if (isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operations)) {
				basePart.addFilterToOperations(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Operation); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for Operations
				// End of user code
			}
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}












	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.dSName) {
			return EsbPackage.eINSTANCE.getDataServiceCallMediator_DSName();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.operationType) {
			return EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationType();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.operationName) {
			return EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationName();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.operations) {
			return EsbPackage.eINSTANCE.getDataServiceCallMediator_Operations();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.targetType) {
			return EsbPackage.eINSTANCE.getDataServiceCallMediator_TargetType();
		}
		if (editorKey == EsbViewsRepository.DataServiceCallMediator.Properties.propertyName) {
			return EsbPackage.eINSTANCE.getDataServiceCallMediator_PropertyName();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DataServiceCallMediator dataServiceCallMediator = (DataServiceCallMediator)semanticObject;
		if (EsbViewsRepository.DataServiceCallMediator.Properties.description == event.getAffectedEditor()) {
			dataServiceCallMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dataServiceCallMediator.getCommentsList().clear();
				dataServiceCallMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.reverse == event.getAffectedEditor()) {
			dataServiceCallMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.dSName == event.getAffectedEditor()) {
			dataServiceCallMediator.setDSName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.operationType == event.getAffectedEditor()) {
			dataServiceCallMediator.setOperationType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.operationName == event.getAffectedEditor()) {
			dataServiceCallMediator.setOperationName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
			Object[] existingOps = operationsSettings.getValue();
			for (Object existingOp : existingOps) {
				OperationImpl operation = (OperationImpl)existingOp;
				operationsSettings.removeFromReference(operation);
			}
			OperationImpl newOperation = new OperationImpl();
			newOperation.setOperationName((String)event.getNewValue());
			operationsSettings.addToReference(newOperation);
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.operations == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, operationsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				operationsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				operationsSettings.move(event.getNewIndex(), (Operation) event.getNewValue());
			}
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.targetType == event.getAffectedEditor()) {
			dataServiceCallMediator.setTargetType((TargetType)event.getNewValue());
		}
		if (EsbViewsRepository.DataServiceCallMediator.Properties.propertyName == event.getAffectedEditor()) {
			dataServiceCallMediator.setPropertyName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DataServiceCallMediatorPropertiesEditionPart basePart = (DataServiceCallMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.commentsList)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCommentsList((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCommentsList(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCommentsList(newValueAsList);
				}
			}
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataServiceCallMediator_DSName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.dSName)) {
				if (msg.getNewValue() != null) {
					basePart.setDSName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDSName("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operationType)) {
				if (msg.getNewValue() != null) {
					basePart.setOperationType(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOperationType("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operationName)) {
				if (msg.getNewValue() != null) {
					basePart.setOperationName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOperationName("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataServiceCallMediator_Operations().equals(msg.getFeature()) && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.operations))
				basePart.updateOperations();
			if (EsbPackage.eINSTANCE.getDataServiceCallMediator_TargetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.targetType))
				basePart.setTargetType((TargetType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataServiceCallMediator_PropertyName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServiceCallMediator.Properties.propertyName)) {
				if (msg.getNewValue() != null) {
					basePart.setPropertyName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setPropertyName("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EsbPackage.eINSTANCE.getEsbElement_Description(),
			EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
			EsbPackage.eINSTANCE.getMediator_Reverse(),
			EsbPackage.eINSTANCE.getDataServiceCallMediator_DSName(),
			EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationType(),
			EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationName(),
			EsbPackage.eINSTANCE.getDataServiceCallMediator_Operations(),
			EsbPackage.eINSTANCE.getDataServiceCallMediator_TargetType(),
			EsbPackage.eINSTANCE.getDataServiceCallMediator_PropertyName()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EsbViewsRepository.DataServiceCallMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.dSName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServiceCallMediator_DSName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServiceCallMediator_DSName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.operationType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.operationName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServiceCallMediator_OperationName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.targetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServiceCallMediator_TargetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServiceCallMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServiceCallMediator.Properties.propertyName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServiceCallMediator_PropertyName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServiceCallMediator_PropertyName().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
