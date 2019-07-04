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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.Param;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl#getParamName <em>Param Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl#getParamValueType <em>Param Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl#getParamValue <em>Param Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl#getParamExpression <em>Param Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ParamImpl#getEvauator <em>Evauator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParamImpl extends EsbNodeImpl implements Param {
    /**
     * The default value of the '{@link #getParamName() <em>Param Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamName()
     * @generated
     * @ordered
     */
    protected static final String PARAM_NAME_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getParamName() <em>Param Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamName()
     * @generated
     * @ordered
     */
    protected String paramName = PARAM_NAME_EDEFAULT;
    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final String TYPE_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected String type = TYPE_EDEFAULT;
    /**
     * The default value of the '{@link #getParamValueType() <em>Param Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamValueType()
     * @generated
     * @ordered
     */
    protected static final PayloadFactoryArgumentType PARAM_VALUE_TYPE_EDEFAULT = PayloadFactoryArgumentType.VALUE;
    /**
     * The cached value of the '{@link #getParamValueType() <em>Param Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamValueType()
     * @generated
     * @ordered
     */
    protected PayloadFactoryArgumentType paramValueType = PARAM_VALUE_TYPE_EDEFAULT;
    /**
     * The default value of the '{@link #getParamValue() <em>Param Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamValue()
     * @generated
     * @ordered
     */
    protected static final String PARAM_VALUE_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getParamValue() <em>Param Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamValue()
     * @generated
     * @ordered
     */
    protected String paramValue = PARAM_VALUE_EDEFAULT;
    /**
     * The cached value of the '{@link #getParamExpression() <em>Param Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParamExpression()
     * @generated
     * @ordered
     */
    protected NamespacedProperty paramExpression;
    /**
     * The default value of the '{@link #getEvauator() <em>Evauator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvauator()
     * @generated
     * @ordered
     */
    protected static final MediaType EVAUATOR_EDEFAULT = MediaType.XML;
    /**
     * The cached value of the '{@link #getEvauator() <em>Evauator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEvauator()
     * @generated
     * @ordered
     */
    protected MediaType evauator = EVAUATOR_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public ParamImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.PARAM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParamName(String newParamName) {
        String oldParamName = paramName;
        paramName = newParamName;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__PARAM_NAME, oldParamName, paramName));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getType() {
        return type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(String newType) {
        String oldType = type;
        type = newType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__TYPE, oldType, type));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PayloadFactoryArgumentType getParamValueType() {
        return paramValueType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParamValueType(PayloadFactoryArgumentType newParamValueType) {
        PayloadFactoryArgumentType oldParamValueType = paramValueType;
        paramValueType = newParamValueType == null ? PARAM_VALUE_TYPE_EDEFAULT : newParamValueType;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__PARAM_VALUE_TYPE, oldParamValueType, paramValueType));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParamValue(String newParamValue) {
        String oldParamValue = paramValue;
        paramValue = newParamValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__PARAM_VALUE, oldParamValue, paramValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamespacedProperty getParamExpression() {
        return paramExpression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParamExpression(NamespacedProperty newParamExpression, NotificationChain msgs) {
        NamespacedProperty oldParamExpression = paramExpression;
        paramExpression = newParamExpression;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__PARAM_EXPRESSION, oldParamExpression, newParamExpression);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParamExpression(NamespacedProperty newParamExpression) {
        if (newParamExpression != paramExpression) {
            NotificationChain msgs = null;
            if (paramExpression != null)
                msgs = ((InternalEObject)paramExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PARAM__PARAM_EXPRESSION, null, msgs);
            if (newParamExpression != null)
                msgs = ((InternalEObject)newParamExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PARAM__PARAM_EXPRESSION, null, msgs);
            msgs = basicSetParamExpression(newParamExpression, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__PARAM_EXPRESSION, newParamExpression, newParamExpression));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MediaType getEvauator() {
        return evauator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEvauator(MediaType newEvauator) {
        MediaType oldEvauator = evauator;
        evauator = newEvauator == null ? EVAUATOR_EDEFAULT : newEvauator;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PARAM__EVAUATOR, oldEvauator, evauator));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case EsbPackage.PARAM__PARAM_EXPRESSION:
                return basicSetParamExpression(null, msgs);
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
            case EsbPackage.PARAM__PARAM_NAME:
                return getParamName();
            case EsbPackage.PARAM__TYPE:
                return getType();
            case EsbPackage.PARAM__PARAM_VALUE_TYPE:
                return getParamValueType();
            case EsbPackage.PARAM__PARAM_VALUE:
                return getParamValue();
            case EsbPackage.PARAM__PARAM_EXPRESSION:
                return getParamExpression();
            case EsbPackage.PARAM__EVAUATOR:
                return getEvauator();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case EsbPackage.PARAM__PARAM_NAME:
                setParamName((String)newValue);
                return;
            case EsbPackage.PARAM__TYPE:
                setType((String)newValue);
                return;
            case EsbPackage.PARAM__PARAM_VALUE_TYPE:
                setParamValueType((PayloadFactoryArgumentType)newValue);
                return;
            case EsbPackage.PARAM__PARAM_VALUE:
                setParamValue((String)newValue);
                return;
            case EsbPackage.PARAM__PARAM_EXPRESSION:
                setParamExpression((NamespacedProperty)newValue);
                return;
            case EsbPackage.PARAM__EVAUATOR:
                setEvauator((MediaType)newValue);
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
            case EsbPackage.PARAM__PARAM_NAME:
                setParamName(PARAM_NAME_EDEFAULT);
                return;
            case EsbPackage.PARAM__TYPE:
                setType(TYPE_EDEFAULT);
                return;
            case EsbPackage.PARAM__PARAM_VALUE_TYPE:
                setParamValueType(PARAM_VALUE_TYPE_EDEFAULT);
                return;
            case EsbPackage.PARAM__PARAM_VALUE:
                setParamValue(PARAM_VALUE_EDEFAULT);
                return;
            case EsbPackage.PARAM__PARAM_EXPRESSION:
                setParamExpression((NamespacedProperty)null);
                return;
            case EsbPackage.PARAM__EVAUATOR:
                setEvauator(EVAUATOR_EDEFAULT);
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
            case EsbPackage.PARAM__PARAM_NAME:
                return PARAM_NAME_EDEFAULT == null ? paramName != null : !PARAM_NAME_EDEFAULT.equals(paramName);
            case EsbPackage.PARAM__TYPE:
                return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
            case EsbPackage.PARAM__PARAM_VALUE_TYPE:
                return paramValueType != PARAM_VALUE_TYPE_EDEFAULT;
            case EsbPackage.PARAM__PARAM_VALUE:
                return PARAM_VALUE_EDEFAULT == null ? paramValue != null : !PARAM_VALUE_EDEFAULT.equals(paramValue);
            case EsbPackage.PARAM__PARAM_EXPRESSION:
                return paramExpression != null;
            case EsbPackage.PARAM__EVAUATOR:
                return evauator != EVAUATOR_EDEFAULT;
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
        result.append(" (paramName: ");
        result.append(paramName);
        result.append(", type: ");
        result.append(type);
        result.append(", paramValueType: ");
        result.append(paramValueType);
        result.append(", paramValue: ");
        result.append(paramValue);
        result.append(", evauator: ");
        result.append(evauator);
        result.append(')');
        return result.toString();
    }

} // ParamImpl
