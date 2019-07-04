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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamName <em>Param Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getType <em>Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamValueType <em>Param Value Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamValue <em>Param Value</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamExpression <em>Param Expression</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getEvauator <em>Evauator</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam()
 * @model
 * @generated
 */
public interface Param extends EsbNode {

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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam_ParamName()
     * @model
     * @generated
     */
    String getParamName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamName <em>Param Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Param Name</em>' attribute.
     * @see #getParamName()
     * @generated
     */
    void setParamName(String value);

    /**
     * Returns the value of the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Type</em>' attribute.
     * @see #setType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam_Type()
     * @model
     * @generated
     */
    String getType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getType <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type</em>' attribute.
     * @see #getType()
     * @generated
     */
    void setType(String value);

    /**
     * Returns the value of the '<em><b>Param Value Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Param Value Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Param Value Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType
     * @see #setParamValueType(PayloadFactoryArgumentType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam_ParamValueType()
     * @model
     * @generated
     */
    PayloadFactoryArgumentType getParamValueType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamValueType <em>Param Value Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Param Value Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType
     * @see #getParamValueType()
     * @generated
     */
    void setParamValueType(PayloadFactoryArgumentType value);

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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam_ParamValue()
     * @model
     * @generated
     */
    String getParamValue();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamValue <em>Param Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Param Value</em>' attribute.
     * @see #getParamValue()
     * @generated
     */
    void setParamValue(String value);

    /**
     * Returns the value of the '<em><b>Param Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Param Expression</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Param Expression</em>' containment reference.
     * @see #setParamExpression(NamespacedProperty)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam_ParamExpression()
     * @model containment="true"
     * @generated
     */
    NamespacedProperty getParamExpression();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getParamExpression <em>Param Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Param Expression</em>' containment reference.
     * @see #getParamExpression()
     * @generated
     */
    void setParamExpression(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Evauator</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.MediaType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Evauator</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Evauator</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.MediaType
     * @see #setEvauator(MediaType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getParam_Evauator()
     * @model
     * @generated
     */
    MediaType getEvauator();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.Param#getEvauator <em>Evauator</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Evauator</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.MediaType
     * @see #getEvauator()
     * @generated
     */
    void setEvauator(MediaType value);
} // Param
