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

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallTargetType;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperationType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallOperationsImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.DataServicesCallMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;


// End of user code

/**
 * 
 * 
 */
public class DataServicesCallMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
   * Settings for operations ReferencesTable
   */
  protected ReferencesTableSettings operationsSettings;



  /**
	 * Default constructor
	 * 
	 */
	public DataServicesCallMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject dataServicesCallMediator, String editing_mode) {
		super(editingContext, dataServicesCallMediator, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EsbViewsRepository.class;
		partKey = EsbViewsRepository.DataServicesCallMediator.class;
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
			
			final DataServicesCallMediator dataServicesCallMediator = (DataServicesCallMediator)elt;
			final DataServicesCallMediatorPropertiesEditionPart basePart = (DataServicesCallMediatorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.description))
				basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServicesCallMediator.getDescription()));
			
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.commentsList))
				basePart.setCommentsList(dataServicesCallMediator.getCommentsList());
			
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.reverse)) {
				basePart.setReverse(dataServicesCallMediator.isReverse());
			}
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType)) {
				basePart.initSourceType(EEFUtils.choiceOfValues(dataServicesCallMediator, EsbPackage.eINSTANCE.getDataServicesCallMediator_SourceType()), dataServicesCallMediator.getSourceType());
			}
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.targetType)) {
				basePart.initTargetType(EEFUtils.choiceOfValues(dataServicesCallMediator, EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType()), dataServicesCallMediator.getTargetType());
			}
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.serviceName)) {
				basePart.setServiceName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServicesCallMediator.getServiceName()));
			}
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.operationType)) {
				basePart.setOperationType(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServicesCallMediator.getOperationType()));
				//basePart.initOperationType(EEFUtils.choiceOfValues(dataServicesCallMediator, EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationType()), dataServicesCallMediator.getOperationType());
			}
			if (isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.operationName)) {
				basePart.setOperationName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, dataServicesCallMediator.getOperationName()));
			}
			// init filters
			
			
			
			
			
			
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
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.description) {
			return EsbPackage.eINSTANCE.getEsbElement_Description();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.commentsList) {
			return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.reverse) {
			return EsbPackage.eINSTANCE.getMediator_Reverse();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.sourceType) {
			return EsbPackage.eINSTANCE.getDataServicesCallMediator_SourceType();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.targetType) {
			return EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.serviceName) {
			return EsbPackage.eINSTANCE.getDataServicesCallMediator_ServiceName();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.operationType) {
			return EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationType();
		}
		if (editorKey == EsbViewsRepository.DataServicesCallMediator.Properties.operationName) {
			return EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationName();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		DataServicesCallMediator dataServicesCallMediator = (DataServicesCallMediator)semanticObject;
		if (EsbViewsRepository.DataServicesCallMediator.Properties.description == event.getAffectedEditor()) {
			dataServicesCallMediator.setDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.commentsList == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				dataServicesCallMediator.getCommentsList().clear();
				dataServicesCallMediator.getCommentsList().addAll(((EList) event.getNewValue()));
			}
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.reverse == event.getAffectedEditor()) {
			dataServicesCallMediator.setReverse((Boolean)event.getNewValue());
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.sourceType == event.getAffectedEditor()) {
			dataServicesCallMediator.setSourceType((DataServicesCallSourceType)event.getNewValue());
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.targetType == event.getAffectedEditor()) {
			dataServicesCallMediator.setTargetType((DataServicesCallTargetType)event.getNewValue());
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.serviceName == event.getAffectedEditor()) {
			dataServicesCallMediator.setServiceName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.operationType == event.getAffectedEditor()) {
			dataServicesCallMediator.setOperationType((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EsbViewsRepository.DataServicesCallMediator.Properties.operationName == event.getAffectedEditor()) {
			dataServicesCallMediator.setOperationName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
			if (operationsSettings != null) {
				Object[] existingOps = operationsSettings.getValue();
				for (Object existingOp : existingOps) {
					DataServicesCallOperationsImpl operation = (DataServicesCallOperationsImpl)existingOp;
					operationsSettings.removeFromReference(operation);
				}
				DataServicesCallOperationsImpl newOperation = new DataServicesCallOperationsImpl();
				newOperation.setOperationName((String)event.getNewValue());
				operationsSettings.addToReference(newOperation);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			DataServicesCallMediatorPropertiesEditionPart basePart = (DataServicesCallMediatorPropertiesEditionPart)editingPart;
			if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.description)) {
				if (msg.getNewValue() != null) {
					basePart.setDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setDescription("");
				}
			}
			if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.commentsList)) {
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
			
			if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.reverse))
				basePart.setReverse((Boolean)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataServicesCallMediator_SourceType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.sourceType))
				basePart.setSourceType((DataServicesCallSourceType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.targetType))
				basePart.setTargetType((DataServicesCallTargetType)msg.getNewValue());
			
			if (EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.operationType)) {
				//basePart.setOperationType((DataServicesCallOperationType)msg.getNewValue());
				if (msg.getNewValue() != null) {
					basePart.setOperationName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOperationName("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataServicesCallMediator_ServiceName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.serviceName)) {
				if (msg.getNewValue() != null) {
					basePart.setServiceName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setServiceName("");
				}
			}
			if (EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EsbViewsRepository.DataServicesCallMediator.Properties.operationName)) {
				if (msg.getNewValue() != null) {
					basePart.setOperationName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setOperationName("");
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
			EsbPackage.eINSTANCE.getDataServicesCallMediator_SourceType(),
			EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType(),
			EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationName(),
			EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationType(),
			EsbPackage.eINSTANCE.getDataServicesCallMediator_ServiceName()		);
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
				if (EsbViewsRepository.DataServicesCallMediator.Properties.description == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.commentsList == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.reverse == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.sourceType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServicesCallMediator_SourceType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServicesCallMediator_SourceType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.targetType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.operationType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServicesCallMediator_TargetType().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.serviceName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServicesCallMediator_ServiceName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServicesCallMediator_ServiceName().getEAttributeType(), newValue);
				}
				if (EsbViewsRepository.DataServicesCallMediator.Properties.operationName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EsbPackage.eINSTANCE.getDataServicesCallMediator_OperationName().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}
	// Start of user code for help compatibility

    /**
     * @generated NOT
     */
    @Override
    public String getHelpContent(Object key, int kind) {
        return EEFPropertyViewUtil.getHelpContent(key);
    }
    
    // End of user code
}
