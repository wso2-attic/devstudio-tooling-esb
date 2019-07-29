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
import org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediatorInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediatorOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Operation;
import org.wso2.developerstudio.eclipse.gmf.esb.OperationType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Service Call Mediator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getDSName <em>DS Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.DataServiceCallMediatorImpl#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataServiceCallMediatorImpl extends MediatorImpl implements DataServiceCallMediator {
    /**
     * The cached value of the '{@link #getInputConnector() <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputConnector()
     * @generated
     * @ordered
     */
    protected DataServiceCallMediatorInputConnector inputConnector;
    /**
     * The cached value of the '{@link #getOutputConnector() <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutputConnector()
     * @generated
     * @ordered
     */
    protected DataServiceCallMediatorOutputConnector outputConnector;

    /**
     * The default value of the '{@link #getDSName() <em>DS Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDSName()
     * @generated
     * @ordered
     */
    protected static final String DS_NAME_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getDSName() <em>DS Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDSName()
     * @generated
     * @ordered
     */
    protected String dsName = DS_NAME_EDEFAULT;
    /**
     * The default value of the '{@link #getOperationType() <em>Operation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationType()
     * @generated
     * @ordered
     */
    protected static final String OPERATION_TYPE_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getOperationType() <em>Operation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationType()
     * @generated
     * @ordered
     */
    protected String operationType = OPERATION_TYPE_EDEFAULT;
    /**
     * The default value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationName()
     * @generated
     * @ordered
     */
    protected static final String OPERATION_NAME_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getOperationName() <em>Operation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationName()
     * @generated
     * @ordered
     */
    protected String operationName = OPERATION_NAME_EDEFAULT;
    /**
     * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperations()
     * @generated
     * @ordered
     */
    protected EList<Operation> operations;
    /**
     * The default value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetType()
     * @generated
     * @ordered
     */
    protected static final TargetType TARGET_TYPE_EDEFAULT = TargetType.ENVELOPE;
    /**
     * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetType()
     * @generated
     * @ordered
     */
    protected TargetType targetType = TARGET_TYPE_EDEFAULT;
    /**
     * The default value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPropertyName()
     * @generated
     * @ordered
     */
    protected static final String PROPERTY_NAME_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getPropertyName() <em>Property Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPropertyName()
     * @generated
     * @ordered
     */
    protected String propertyName = PROPERTY_NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataServiceCallMediatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.DATA_SERVICE_CALL_MEDIATOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServiceCallMediatorInputConnector getInputConnector() {
        return inputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInputConnector(DataServiceCallMediatorInputConnector newInputConnector,
            NotificationChain msgs) {
        DataServiceCallMediatorInputConnector oldInputConnector = inputConnector;
        inputConnector = newInputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR, oldInputConnector, newInputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInputConnector(DataServiceCallMediatorInputConnector newInputConnector) {
        if (newInputConnector != inputConnector) {
            NotificationChain msgs = null;
            if (inputConnector != null)
                msgs = ((InternalEObject)inputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            if (newInputConnector != null)
                msgs = ((InternalEObject)newInputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR, null, msgs);
            msgs = basicSetInputConnector(newInputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR, newInputConnector, newInputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataServiceCallMediatorOutputConnector getOutputConnector() {
        return outputConnector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutputConnector(DataServiceCallMediatorOutputConnector newOutputConnector,
            NotificationChain msgs) {
        DataServiceCallMediatorOutputConnector oldOutputConnector = outputConnector;
        outputConnector = newOutputConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR, oldOutputConnector, newOutputConnector);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOutputConnector(DataServiceCallMediatorOutputConnector newOutputConnector) {
        if (newOutputConnector != outputConnector) {
            NotificationChain msgs = null;
            if (outputConnector != null)
                msgs = ((InternalEObject)outputConnector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            if (newOutputConnector != null)
                msgs = ((InternalEObject)newOutputConnector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR, null, msgs);
            msgs = basicSetOutputConnector(newOutputConnector, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR, newOutputConnector, newOutputConnector));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDSName() {
        return dsName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDSName(String newDSName) {
        String oldDSName = dsName;
        dsName = newDSName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__DS_NAME, oldDSName, dsName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOperationType() {
        return operationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationType(String newOperationType) {
        String oldOperationType = operationType;
        operationType = newOperationType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_TYPE, oldOperationType, operationType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOperationName(String newOperationName) {
        String oldOperationName = operationName;
        operationName = newOperationName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_NAME, oldOperationName, operationName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Operation> getOperations() {
        if (operations == null) {
            operations = new EObjectContainmentEList<Operation>(Operation.class, this, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATIONS);
        }
        return operations;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TargetType getTargetType() {
        return targetType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetType(TargetType newTargetType) {
        TargetType oldTargetType = targetType;
        targetType = newTargetType == null ? TARGET_TYPE_EDEFAULT : newTargetType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__TARGET_TYPE, oldTargetType, targetType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPropertyName(String newPropertyName) {
        String oldPropertyName = propertyName;
        propertyName = newPropertyName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.DATA_SERVICE_CALL_MEDIATOR__PROPERTY_NAME, oldPropertyName, propertyName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR:
                return basicSetInputConnector(null, msgs);
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                return basicSetOutputConnector(null, msgs);
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATIONS:
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
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR:
                return getInputConnector();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                return getOutputConnector();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__DS_NAME:
                return getDSName();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_TYPE:
                return getOperationType();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_NAME:
                return getOperationName();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATIONS:
                return getOperations();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__TARGET_TYPE:
                return getTargetType();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__PROPERTY_NAME:
                return getPropertyName();
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
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((DataServiceCallMediatorInputConnector)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((DataServiceCallMediatorOutputConnector)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__DS_NAME:
                setDSName((String)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_TYPE:
                setOperationType((String)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_NAME:
                setOperationName((String)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATIONS:
                getOperations().clear();
                getOperations().addAll((Collection<? extends Operation>)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__TARGET_TYPE:
                setTargetType((TargetType)newValue);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__PROPERTY_NAME:
                setPropertyName((String)newValue);
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
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR:
                setInputConnector((DataServiceCallMediatorInputConnector)null);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                setOutputConnector((DataServiceCallMediatorOutputConnector)null);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__DS_NAME:
                setDSName(DS_NAME_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_TYPE:
                setOperationType(OPERATION_TYPE_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_NAME:
                setOperationName(OPERATION_NAME_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATIONS:
                getOperations().clear();
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__TARGET_TYPE:
                setTargetType(TARGET_TYPE_EDEFAULT);
                return;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__PROPERTY_NAME:
                setPropertyName(PROPERTY_NAME_EDEFAULT);
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
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__INPUT_CONNECTOR:
                return inputConnector != null;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OUTPUT_CONNECTOR:
                return outputConnector != null;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__DS_NAME:
                return DS_NAME_EDEFAULT == null ? dsName != null : !DS_NAME_EDEFAULT.equals(dsName);
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_TYPE:
                return OPERATION_TYPE_EDEFAULT == null ? operationType != null : !OPERATION_TYPE_EDEFAULT.equals(operationType);
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATION_NAME:
                return OPERATION_NAME_EDEFAULT == null ? operationName != null : !OPERATION_NAME_EDEFAULT.equals(operationName);
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__OPERATIONS:
                return operations != null && !operations.isEmpty();
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__TARGET_TYPE:
                return targetType != TARGET_TYPE_EDEFAULT;
            case EsbPackage.DATA_SERVICE_CALL_MEDIATOR__PROPERTY_NAME:
                return PROPERTY_NAME_EDEFAULT == null ? propertyName != null : !PROPERTY_NAME_EDEFAULT.equals(propertyName);
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
        result.append(" (DSName: ");
        result.append(dsName);
        result.append(", operationType: ");
        result.append(operationType);
        result.append(", OperationName: ");
        result.append(operationName);
        result.append(", targetType: ");
        result.append(targetType);
        result.append(", PropertyName: ");
        result.append(propertyName);
        result.append(')');
        return result.toString();
    }

} // DataServiceCallMediatorImpl
