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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueParam;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Name Value Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueParamImpl#getParamName <em>Param Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AbstractNameValueParamImpl#getParamValue <em>Param Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractNameValueParamImpl extends EObjectImpl implements AbstractNameValueParam {
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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AbstractNameValueParamImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EsbPackage.Literals.ABSTRACT_NAME_VALUE_PARAM;
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
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_NAME, oldParamName, paramName));
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
            eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_VALUE, oldParamValue, paramValue));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_NAME:
                return getParamName();
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_VALUE:
                return getParamValue();
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
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_NAME:
                setParamName((String)newValue);
                return;
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_VALUE:
                setParamValue((String)newValue);
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
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_NAME:
                setParamName(PARAM_NAME_EDEFAULT);
                return;
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_VALUE:
                setParamValue(PARAM_VALUE_EDEFAULT);
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
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_NAME:
                return PARAM_NAME_EDEFAULT == null ? paramName != null : !PARAM_NAME_EDEFAULT.equals(paramName);
            case EsbPackage.ABSTRACT_NAME_VALUE_PARAM__PARAM_VALUE:
                return PARAM_VALUE_EDEFAULT == null ? paramValue != null : !PARAM_VALUE_EDEFAULT.equals(paramValue);
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
        result.append(", paramValue: ");
        result.append(paramValue);
        result.append(')');
        return result.toString();
    }

} // AbstractNameValueParamImpl
