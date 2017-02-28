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
import org.apache.synapse.endpoints.WSDLEndpoint;
import org.apache.synapse.mediators.MediatorProperty;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.apache.synapse.util.xpath.SynapseXPath;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.jaxen.JaxenException;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
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
			List<Endpoint> endPoints) throws TransformerException {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		
		Endpoint endPoint =(Endpoint)create(visualEndPoint, visualEndPoint.getEndPointName());
		endPoints.add(endPoint);			

		// Transform endpoint output data flow.
		transformEndpointOutflow(info);

	}
	
	public WSDLEndpoint create(WSDLEndPoint visualEndPoint,String name) throws TransformerException{
		WSDLEndpoint synapseWSDLEP = new WSDLEndpoint();
		synapseWSDLEP.setWsdlURI(visualEndPoint.getWsdlUri());
		synapseWSDLEP.setServiceName(visualEndPoint.getService());
		synapseWSDLEP.setPortName(visualEndPoint.getPort());		
		if(StringUtils.isNotBlank(name)){
			synapseWSDLEP.setName(name);
		}	
		if(StringUtils.isNotBlank(visualEndPoint.getVersion())){
			synapseWSDLEP.setVersion(visualEndPoint.getVersion());
		}
		try {
			createAdvanceOptions(visualEndPoint,synapseWSDLEP);
		} catch (JaxenException e) {
			throw new TransformerException(e);
		}		
		return synapseWSDLEP;
	}	

	public org.apache.synapse.SynapseArtifact create(WsdlEndpointFormPage wsdlEndpointFormPage) throws NumberFormatException, JaxenException{
		WSDLEndpoint synapseWSDLEP = new WSDLEndpoint();
		synapseWSDLEP.setWsdlURI(wsdlEndpointFormPage.getWsdlEP_WsdlUri().getText());
		synapseWSDLEP.setServiceName(wsdlEndpointFormPage.getWsdlEP_Service().getText());
		synapseWSDLEP.setPortName(wsdlEndpointFormPage.getWsdlEP_Port().getText());		
		if(StringUtils.isNotBlank(wsdlEndpointFormPage.getEndpointName().getText())){
			synapseWSDLEP.setName(wsdlEndpointFormPage.getEndpointName().getText());
		}		
		if(StringUtils.isNotBlank(wsdlEndpointFormPage.getEndpointVersion().getText())){
			synapseWSDLEP.setVersion(wsdlEndpointFormPage.getEndpointVersion().getText());
		}
		createAdvanceOptions(wsdlEndpointFormPage, synapseWSDLEP);	
		
		if(wsdlEndpointFormPage.endpointPropertyList != null && wsdlEndpointFormPage.endpointPropertyList.size()>0){
			saveProperties(wsdlEndpointFormPage,synapseWSDLEP);
		}
		if (wsdlEndpointFormPage.isTemplate()) {
			return createTemplate(wsdlEndpointFormPage, synapseWSDLEP);
		} else {
			return synapseWSDLEP;
		}
	}	

	
	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {
		
		Assert.isTrue(subject instanceof WSDLEndPoint, "Invalid subject");
		WSDLEndPoint visualEndPoint = (WSDLEndPoint) subject;
		Endpoint synapseEP = create(visualEndPoint, visualEndPoint.getEndPointName());
		setEndpointToSendOrCallMediator(sequence, synapseEP);
	}
	

	/**
	 * Save endpoint properties
	 * 
	 * @param model
	 * @param endpoint
	 */
	protected void saveProperties(WsdlEndpointFormPage endpointFormPage, org.apache.synapse.endpoints.WSDLEndpoint synapseHttpEP) {
		
		for(EndPointProperty property : endpointFormPage.endpointPropertyList){
			MediatorProperty mediatorProperty = new MediatorProperty();
			mediatorProperty.setName(property.getName());

			if (property.getValueType().toString().equals("EXPRESSION")) {
				SynapseXPath XPath = null;
				try {
					XPath = new SynapseXPath(property.getValueExpression().getPropertyValue());
					for (int i = 0; i < property.getValueExpression().getNamespaces().keySet().size(); ++i) {
						String prefix = (String) property.getValueExpression().getNamespaces().keySet().toArray()[i];
						String namespaceUri = property.getValueExpression().getNamespaces().get(prefix);
						XPath.addNamespace(prefix, namespaceUri);
					}
					mediatorProperty.setExpression(XPath);
				} catch (JaxenException e) {
					log.error("Error while persisting Endpoint properties", e);
				}
			} else if (property.getValueType().toString().equals("LITERAL")) {
				mediatorProperty.setValue(property.getValue());
			}

			mediatorProperty.setScope(property.getScope().toString().toLowerCase());
			synapseHttpEP.addProperty(mediatorProperty);
		}
	}

}
