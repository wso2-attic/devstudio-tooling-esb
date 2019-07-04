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
package org.wso2.developerstudio.eclipse.gmf.esb;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Name Value Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueParam#getParamName <em>Param Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueParam#getParamValue <em>Param Value</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueParam()
 * @model
 * @generated
 */
public interface AbstractNameValueParam extends EObject {
    /**
     * Returns the value of the '<em><b>Param Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Param Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Param Name</em>' attribute.
     * @see #setParamName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueParam_ParamName()
     * @model
     * @generated
     */
    String getParamName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueParam#getParamName <em>Param Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Param Name</em>' attribute.
     * @see #getParamName()
     * @generated
     */
    void setParamName(String value);

    /**
     * Returns the value of the '<em><b>Param Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Param Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Param Value</em>' attribute.
     * @see #setParamValue(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAbstractNameValueParam_ParamValue()
     * @model
     * @generated
     */
    String getParamValue();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.AbstractNameValueParam#getParamValue <em>Param Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Param Value</em>' attribute.
     * @see #getParamValue()
     * @generated
     */
    void setParamValue(String value);

} // AbstractNameValueParam
