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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Service Call Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getDSName <em>DS Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getPropertyName <em>Property Name</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator()
 * @model
 * @generated
 */
public interface DataServiceCallMediator extends Mediator {

    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(DataServiceCallMediatorInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    DataServiceCallMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(DataServiceCallMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(DataServiceCallMediatorOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    DataServiceCallMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(DataServiceCallMediatorOutputConnector value);

    /**
     * Returns the value of the '<em><b>DS Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>DS Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>DS Name</em>' attribute.
     * @see #setDSName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_DSName()
     * @model
     * @generated
     */
    String getDSName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getDSName <em>DS Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>DS Name</em>' attribute.
     * @see #getDSName()
     * @generated
     */
    void setDSName(String value);

    /**
     * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Type</em>' attribute.
     * @see #setOperationType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_OperationType()
     * @model
     * @generated
     */
    String getOperationType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOperationType <em>Operation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Type</em>' attribute.
     * @see #getOperationType()
     * @generated
     */
    void setOperationType(String value);

    /**
     * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Name</em>' attribute.
     * @see #setOperationName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_OperationName()
     * @model
     * @generated
     */
    String getOperationName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getOperationName <em>Operation Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Name</em>' attribute.
     * @see #getOperationName()
     * @generated
     */
    void setOperationName(String value);

    /**
     * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.Operation}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operations</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_Operations()
     * @model containment="true"
     * @generated
     */
    EList<Operation> getOperations();

    /**
     * Returns the value of the '<em><b>Target Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.TargetType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.TargetType
     * @see #setTargetType(TargetType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_TargetType()
     * @model
     * @generated
     */
    TargetType getTargetType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getTargetType <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.TargetType
     * @see #getTargetType()
     * @generated
     */
    void setTargetType(TargetType value);

    /**
     * Returns the value of the '<em><b>Property Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Property Name</em>' attribute.
     * @see #setPropertyName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServiceCallMediator_PropertyName()
     * @model
     * @generated
     */
    String getPropertyName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServiceCallMediator#getPropertyName <em>Property Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Property Name</em>' attribute.
     * @see #getPropertyName()
     * @generated
     */
    void setPropertyName(String value);
} // DataServiceCallMediator
