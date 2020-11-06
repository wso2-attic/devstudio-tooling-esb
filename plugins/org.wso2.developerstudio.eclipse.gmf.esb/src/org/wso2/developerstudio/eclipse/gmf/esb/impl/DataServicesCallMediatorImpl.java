/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperationType;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperations;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallSourceType;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallTargetType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Services Call Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServicesCallMediatorImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataServicesCallMediatorImpl extends MediatorImpl implements DataServicesCallMediator {
    /**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
    protected DataServicesCallMediatorInputConnector inputConnector;

    /**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
    protected DataServicesCallMediatorOutputConnector outputConnector;

    /**
     * The default value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceType()
     * @generated
     * @ordered
     */
    protected static final DataServicesCallSourceType SOURCE_TYPE_EDEFAULT = DataServicesCallSourceType.BODY;

    /**
     * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceType()
     * @generated
     * @ordered
     */
    protected DataServicesCallSourceType sourceType = SOURCE_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetType()
     * @generated
     * @ordered
     */
    protected static final DataServicesCallTargetType TARGET_TYPE_EDEFAULT = DataServicesCallTargetType.BODY;

    /**
     * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetType()
     * @generated
     * @ordered
     */
    protected DataServicesCallTargetType targetType = TARGET_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceName()
     * @generated
     * @ordered
     */
    protected static final String SERVICE_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getServiceName()
     * @generated
     * @ordered
     */
    protected String serviceName = SERVICE_NAME_EDEFAULT;

    /**
     * The default value of the '{@link #getOperationType() <em>Operation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationType()
     * @generated
     * @ordered
     */
    protected static final DataServicesCallOperationType OPERATION_TYPE_EDEFAULT = DataServicesCallOperationType.SINGLE;

    /**
     * The cached value of the '{@link #getOperationType() <em>Operation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationType()
     * @generated
     * @ordered
     */
    protected DataServicesCallOperationType operationType = OPERATION_TYPE_EDEFAULT;

    /**
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
    protected EList<DataServicesCallOperations> operations;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataServicesCallMediatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.DATA_SERVICES_CALL_MEDIATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServicesCallMediatorInputConnector getInputConnector() {
        return inputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInputConnector(DataServicesCallMediatorInputConnector newInputConnector, NotificationChain msgs) {
        DataServicesCallMediatorInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputConnector(DataServicesCallMediatorInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServicesCallMediatorOutputConnector getOutputConnector() {
        return outputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutputConnector(DataServicesCallMediatorOutputConnector newOutputConnector, NotificationChain msgs) {
        DataServicesCallMediatorOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputConnector(DataServicesCallMediatorOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServicesCallSourceType getSourceType() {
        return sourceType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceType(DataServicesCallSourceType newSourceType) {
        DataServicesCallSourceType oldSourceType = sourceType;
        sourceType = newSourceType == null ? SOURCE_TYPE_EDEFAULT : newSourceType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SOURCE_TYPE, oldSourceType, sourceType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServicesCallTargetType getTargetType() {
        return targetType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetType(DataServicesCallTargetType newTargetType) {
        DataServicesCallTargetType oldTargetType = targetType;
        targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__TARGET_TYPE, oldTargetType, targetType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setServiceName(String newServiceName) {
        String oldServiceName = serviceName;
        serviceName = newServiceName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SERVICE_NAME, oldServiceName, serviceName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServicesCallOperationType getOperationType() {
        return operationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationType(DataServicesCallOperationType newOperationType) {
        DataServicesCallOperationType oldOperationType = operationType;
        operationType = newOperationType == null ? OPERATION_TYPE_EDEFAULT : newOperationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATION_TYPE, oldOperationType, operationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<DataServicesCallOperations> getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentEList<DataServicesCallOperations>(DataServicesCallOperations.class, this, EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATIONS);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATIONS:
                return ((InternalEList<?>)getOperations()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                return getOutputConnector();
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SOURCE_TYPE:
                return getSourceType();
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__TARGET_TYPE:
                return getTargetType();
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SERVICE_NAME:
                return getServiceName();
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATION_TYPE:
                return getOperationType();
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATIONS:
                return getOperations();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((DataServicesCallMediatorInputConnector)newValue);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((DataServicesCallMediatorOutputConnector)newValue);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SOURCE_TYPE:
                setSourceType((DataServicesCallSourceType)newValue);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__TARGET_TYPE:
                setTargetType((DataServicesCallTargetType)newValue);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SERVICE_NAME:
                setServiceName((String)newValue);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATION_TYPE:
                setOperationType((DataServicesCallOperationType)newValue);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection<? extends DataServicesCallOperations>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((DataServicesCallMediatorInputConnector)null);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((DataServicesCallMediatorOutputConnector)null);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SOURCE_TYPE:
                setSourceType(SOURCE_TYPE_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__TARGET_TYPE:
                setTargetType(TARGET_TYPE_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SERVICE_NAME:
                setServiceName(SERVICE_NAME_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATION_TYPE:
                setOperationType(OPERATION_TYPE_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATIONS:
                getOperations().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                return outputConnector != null;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SOURCE_TYPE:
                return sourceType != SOURCE_TYPE_EDEFAULT;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__TARGET_TYPE:
                return targetType != TARGET_TYPE_EDEFAULT;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__SERVICE_NAME:
                return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATION_TYPE:
                return operationType != OPERATION_TYPE_EDEFAULT;
            case EsbPackage.DATA_SERVICES_CALL_MEDIATOR__OPERATIONS:
                return operations != null && !operations.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (sourceType: ");
        result.append(sourceType);
        result.append(", targetType: ");
        result.append(targetType);
        result.append(", serviceName: ");
        result.append(serviceName);
        result.append(", operationType: ");
        result.append(operationType);
        result.append(')');
        return result.toString();
    }

} //DataServicesCallMediatorImpl
