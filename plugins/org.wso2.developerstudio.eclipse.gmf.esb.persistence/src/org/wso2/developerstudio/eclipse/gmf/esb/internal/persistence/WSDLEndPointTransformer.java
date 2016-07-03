/*
 * Copyright 2012-2015 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.forms.editor.FormPage;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.Sequence;
import org.wso2.developerstudio.eclipse.gmf.esb.SequenceInputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.WSDLEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.WsdlEndpointFormPage;

public class WSDLEndPointTransformer extends AbstractEndpointTransformer{

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		Endpoint synapseEP = create(visualEndPoint, visualEndPoint.getEndPointName());
		setEndpointToSendCallOrProxy(information, visualEndPoint, synapseEP);
		
		if(visualEndPoint.getOutputConnector()!=null){
			if(visualEndPoint.getOutputConnector().getOutgoingLink() !=null){
				InputConnector nextInputConnector=visualEndPoint.getOutputConnector().getOutgoingLink().getTarget();
				if((!(nextInputConnector instanceof SequenceInputConnector))||
						((((Sequence)nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink()!=null)&&(!(((Sequence)nextInputConnector.eContainer()).getOutputConnector().get(0).getOutgoingLink().getTarget().eContainer() instanceof EndPoint)))){
					information.setParentSequence(information.getOriginOutSequence());
					information.setTraversalDirection(TransformationInfo.TRAVERSAL_DIRECTION_OUT);
				}else if(visualEndPoint.getInputConnector().getIncomingLinks().get(0).getSource().eContainer() instanceof Sequence){
					information.setParentSequence(information.getCurrentReferredSequence());
				}
			}
		}

		if(!information.isEndPointFound){
			information.isEndPointFound=true;
			information.firstEndPoint=visualEndPoint;
		}

		List<EsbNode> transformedMediators = information.getTransformedMediators();
		if (visualEndPoint.getOutputConnector() != null && visualEndPoint.getOutputConnector().getOutgoingLink()!=null) {
			EsbNode nextElement = (EsbNode) visualEndPoint.getOutputConnector().getOutgoingLink().getTarget().eContainer();
			if (transformedMediators.contains(nextElement)) {
				return;
			}
			transformedMediators.add(nextElement);
		}

		
		// Transform endpoint output data flow.
		doTransform(information, visualEndPoint.getOutputConnector());

	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		
		Endpoint endPoint =(Endpoint)create(visualEndPoint, visualEndPoint.getEndPointName());
		endPoints.add(endPoint);			

		// Transform endpoint output data flow.
		transformEndpointOutflow(info);

	}
	
	public WSDLEndpoint create(WSDLEndPoint visualEndPoint,String name){
		WSDLEndpoint synapseWSDLEP = new WSDLEndpoint();
		synapseWSDLEP.setWsdlURI(visualEndPoint.getWsdlUri());
		synapseWSDLEP.setServiceName(visualEndPoint.getService());
		synapseWSDLEP.setPortName(visualEndPoint.getPort());		
		if(StringUtils.isNotBlank(name)){
			synapseWSDLEP.setName(name);
		}		
		createAdvanceOptions(visualEndPoint,synapseWSDLEP);		
		return synapseWSDLEP;
	}	

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		Endpoint synapseEP = create(visualEndPoint, visualEndPoint.getEndPointName());
		setEndpointToSendOrCallMediator(sequence, synapseEP);
	}
	
	public Endpoint transform(FormPage visualForm) {
		
		WsdlEndpointFormPage formPage = (WsdlEndpointFormPage) visualForm;
		WSDLEndpoint endpoint = new WSDLEndpoint();
		EndpointDefinition definition = new EndpointDefinition();
		
		if (formPage.wsdlEP_Format.getSelectionIndex() == 0) {
			
		} else if (formPage.wsdlEP_Format.getSelectionIndex() == 1) {
			definition.setFormat("soap11");
		} else if (formPage.wsdlEP_Format.getSelectionIndex() == 2) {
			definition.setFormat("soap12");
		} else if (formPage.wsdlEP_Format.getSelectionIndex() == 3) {
			definition.setFormat("pox");
		} else if (formPage.wsdlEP_Format.getSelectionIndex() == 4) {
			definition.setFormat("get");
		} else if (formPage.wsdlEP_Format.getSelectionIndex() == 5) {
			definition.setFormat("rest");
		}
		
		if (formPage.endpointTrace.getSelectionIndex() == 0) {
			definition.enableTracing();
		} else {
			definition.disableTracing();
		}
		
		if (formPage.endpointStatistics.getSelectionIndex() == 0) {
			definition.enableStatistics();
		} else {
			definition.disableStatistics();
		}
		
		if (formPage.wsdlEP_Optimize.getSelectionIndex() == 1) {
			definition.setUseMTOM(true);
		} else if (formPage.wsdlEP_Optimize.getSelectionIndex() == 2) {
			definition.setUseSwa(true);
		}
		
		endpoint.setWsdlURI(formPage.wsdlEP_WsdlUri.getText());
		endpoint.setServiceName(formPage.wsdlEP_Service.getText());
		endpoint.setPortName(formPage.wsdlEP_Port.getText());
		
		super.transform(formPage.getEndpointCommons(), definition);
		
		endpoint.setDefinition(definition);
		
		
		return endpoint;
	}

}
