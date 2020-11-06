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
 * A representation of the model object '<em><b>Data Services Call Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getOperations <em>Operations</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator()
 * @model
 * @generated
 */
public interface DataServicesCallMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(DataServicesCallMediatorInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    DataServicesCallMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(DataServicesCallMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(DataServicesCallMediatorOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    DataServicesCallMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(DataServicesCallMediatorOutputConnector value);

    /**
     * Returns the value of the '<em><b>Source Type</b></em>' attribute.
     * The default value is <code>"body"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallSourceType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallSourceType
     * @see #setSourceType(DataServicesCallSourceType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_SourceType()
     * @model default="body"
     * @generated
     */
    DataServicesCallSourceType getSourceType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getSourceType <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallSourceType
     * @see #getSourceType()
     * @generated
     */
    void setSourceType(DataServicesCallSourceType value);

    /**
     * Returns the value of the '<em><b>Target Type</b></em>' attribute.
     * The default value is <code>"body"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallTargetType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallTargetType
     * @see #setTargetType(DataServicesCallTargetType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_TargetType()
     * @model default="body"
     * @generated
     */
    DataServicesCallTargetType getTargetType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getTargetType <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallTargetType
     * @see #getTargetType()
     * @generated
     */
    void setTargetType(DataServicesCallTargetType value);

    /**
     * Returns the value of the '<em><b>Service Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service Name</em>' attribute.
     * @see #setServiceName(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_ServiceName()
     * @model
     * @generated
     */
    String getServiceName();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getServiceName <em>Service Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service Name</em>' attribute.
     * @see #getServiceName()
     * @generated
     */
    void setServiceName(String value);

    /**
     * Returns the value of the '<em><b>Operation Type</b></em>' attribute.
     * The default value is <code>"single"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperationType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operation Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operation Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperationType
     * @see #setOperationType(DataServicesCallOperationType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_OperationType()
     * @model default="single"
     * @generated
     */
    DataServicesCallOperationType getOperationType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallMediator#getOperationType <em>Operation Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperationType
     * @see #getOperationType()
     * @generated
     */
    void setOperationType(DataServicesCallOperationType value);

    /**
     * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.DataServicesCallOperations}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Operations</em>' containment reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getDataServicesCallMediator_Operations()
     * @model containment="true"
     * @generated
     */
    EList<DataServicesCallOperations> getOperations();

} // DataServicesCallMediator
