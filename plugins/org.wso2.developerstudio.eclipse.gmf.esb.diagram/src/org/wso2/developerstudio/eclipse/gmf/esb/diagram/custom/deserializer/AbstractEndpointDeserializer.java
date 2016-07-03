/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.aspects.statistics.StatisticsConfigurable;
import org.apache.synapse.config.Entry;
import org.apache.synapse.endpoints.AbstractEndpoint;
import org.apache.synapse.endpoints.EndpointDefinition;
import org.apache.synapse.mediators.MediatorProperty;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.editor.FormEditor;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractEndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.ArtifactType;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAddressingVersion;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointAttachmentOptimization;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointMessageFormat;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointTimeOutAction;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.esb.form.editors.article.rcp.ESBFormEditor;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointCommons;
import org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints.EndpointFormPage;

import static org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage.Literals.*;

public abstract class AbstractEndpointDeserializer extends AbstractEsbNodeDeserializer<AbstractEndpoint, AbstractEndPoint>{

	@Deprecated
	protected <T extends AbstractEndpoint> void deserializeEndpoint(T endpoint,AbstractEndPoint visualEndpoint){	
		String suspendErrorCodes=null;
		String retryErrorCodes=null;
		
		if(StringUtils.isNotBlank(endpoint.getName())){
             executeSetValueCommand(END_POINT__END_POINT_NAME, endpoint.getName());
		}
		
        StatisticsConfigurable statisticsConfigurable = endpoint.getDefinition().getAspectConfiguration();
        if (statisticsConfigurable != null && statisticsConfigurable.isStatisticsEnable()) {
            executeSetValueCommand(ABSTRACT_END_POINT__STATISTICS_ENABLED, new Boolean(true));
        } else {
            executeSetValueCommand(ABSTRACT_END_POINT__STATISTICS_ENABLED, new Boolean(false));
        }
        // Fixing TOOLS-2652
        if (endpoint.getDefinition().isTracingEnabled()) {
            executeSetValueCommand(ABSTRACT_END_POINT__TRACE_ENABLED, new Boolean(true));
        } else {
            executeSetValueCommand(ABSTRACT_END_POINT__TRACE_ENABLED, new Boolean(false));
        }
		
		if("soap11".equals(endpoint.getDefinition().getFormat())){
			executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.SOAP_11);
		}else if("soap12".equals(endpoint.getDefinition().getFormat())){
			executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.SOAP_12);
		}else if("pox".equals(endpoint.getDefinition().getFormat())){
			executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.POX);
		}else if("get".equals(endpoint.getDefinition().getFormat())){
			executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.GET);
		}else if("rest".equals(endpoint.getDefinition().getFormat())){
			executeSetValueCommand(ABSTRACT_END_POINT__FORMAT, EndPointMessageFormat.REST);
		}
		
		if(endpoint.getDefinition().isUseMTOM()){
			executeSetValueCommand(ABSTRACT_END_POINT__OPTIMIZE, EndPointAttachmentOptimization.MTOM);
		}else if(endpoint.getDefinition().isUseSwa()){
			executeSetValueCommand(ABSTRACT_END_POINT__OPTIMIZE, EndPointAttachmentOptimization.SWA);
		}
		
		for(Integer code:endpoint.getDefinition().getSuspendErrorCodes()){
			if(suspendErrorCodes==null){
				suspendErrorCodes=code.toString();
			}else{
				suspendErrorCodes=suspendErrorCodes+","+code.toString();
			}
		}		
		executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_ERROR_CODES, suspendErrorCodes);
		executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_INITIAL_DURATION, endpoint.getDefinition().getInitialSuspendDuration());
		executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_MAXIMUM_DURATION, endpoint.getDefinition().getSuspendMaximumDuration());
		executeSetValueCommand(ABSTRACT_END_POINT__SUSPEND_PROGRESSION_FACTOR, endpoint.getDefinition().getSuspendProgressionFactor());
		
		for(Integer code:endpoint.getDefinition().getTimeoutErrorCodes()){
			if(retryErrorCodes==null){
				retryErrorCodes=code.toString();
			}else{
				retryErrorCodes=retryErrorCodes+","+code.toString();
			}
		}
		executeSetValueCommand(ABSTRACT_END_POINT__RETRY_ERROR_CODES, retryErrorCodes);
		executeSetValueCommand(ABSTRACT_END_POINT__RETRY_COUNT, endpoint.getDefinition().getRetriesOnTimeoutBeforeSuspend());
		executeSetValueCommand(ABSTRACT_END_POINT__RETRY_DELAY, (long)endpoint.getDefinition().getRetryDurationOnTimeout());
		
		if(endpoint.getDefinition().getTimeoutAction()==100){
			executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_ACTION, EndPointTimeOutAction.NEVER);
		}else if(endpoint.getDefinition().getTimeoutAction()==101){
			executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_ACTION, EndPointTimeOutAction.DISCARD);
		}else if(endpoint.getDefinition().getTimeoutAction()==102){
			executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_ACTION, EndPointTimeOutAction.FAULT);
		}
		executeSetValueCommand(ABSTRACT_END_POINT__TIME_OUT_DURATION, endpoint.getDefinition().getTimeoutDuration());
		
		if(endpoint.getDefinition().isAddressingOn()){
			executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_ENABLED, true);
			executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_SEPARATE_LISTENER, endpoint.getDefinition().isUseSeparateListener());
			if("final".equals(endpoint.getDefinition().getAddressingVersion())){
				executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_VERSION, EndPointAddressingVersion.FINAL);
			}else{
				executeSetValueCommand(ABSTRACT_END_POINT__ADDRESSING_VERSION, EndPointAddressingVersion.SUBMISSION);
			}
		}
		
		if(endpoint.getDefinition().isReliableMessagingOn()){
			executeSetValueCommand(ABSTRACT_END_POINT__RELIABLE_MESSAGING_ENABLED, true);
			
			RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			String wsRMPolicyKey= endpoint.getDefinition().getWsRMPolicyKey();
			if(wsRMPolicyKey !=null){
				regkey.setKeyValue(wsRMPolicyKey);
			}else{
				regkey.setKeyValue("");
			}			
			executeSetValueCommand(ABSTRACT_END_POINT__RELIABLE_MESSAGING_POLICY, regkey);
		}
		
		if(endpoint.getDefinition().isSecurityOn()){
			executeSetValueCommand(ABSTRACT_END_POINT__SECURITY_ENABLED, true);

			String wsSecPolicyKey = endpoint.getDefinition().getWsSecPolicyKey();
			if (StringUtils.isNotBlank(wsSecPolicyKey)) {
				RegistryKeyProperty regkey = getRegistryKeyForPolicy(wsSecPolicyKey);
				executeSetValueCommand(ABSTRACT_END_POINT__SECURITY_POLICY, regkey);
			}
			
			String inboundPolicyKey = endpoint.getDefinition().getInboundWsSecPolicyKey();
			if (StringUtils.isNotBlank(inboundPolicyKey)) {
				RegistryKeyProperty regkey = getRegistryKeyForPolicy(inboundPolicyKey);
				executeSetValueCommand(ABSTRACT_END_POINT__INBOUND_POLICY, regkey);
			}
			
			String outoundPolicyKey = endpoint.getDefinition().getOutboundWsSecPolicyKey();
			if (StringUtils.isNotBlank(outoundPolicyKey)) {
				RegistryKeyProperty regkey = getRegistryKeyForPolicy(outoundPolicyKey);
				executeSetValueCommand(ABSTRACT_END_POINT__OUTBOUND_POLICY, regkey);
			}
		}
		
		for (Iterator<MediatorProperty> i = endpoint.getProperties().iterator(); i.hasNext();) {
			MediatorProperty next = i.next();
			EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
			property.setName(next.getName());
			
			if(next.getExpression()!=null){
				property.setValueType(PropertyValueType.EXPRESSION);
				NamespacedProperty valueXPath = EsbFactory.eINSTANCE.createNamespacedProperty();
				valueXPath.setPropertyValue(next.getExpression().toString());
				Map<String,String> namespaces = (Map<String,String>)next.getExpression().getNamespaces();
				valueXPath.setNamespaces(namespaces);
				property.setValueExpression(valueXPath);
			}else if(next.getValue()!=null){
				property.setValueType(PropertyValueType.LITERAL);
				property.setValue(next.getValue());
			}			
			
			if(next.getScope()!=null){
				property.setScope(EndPointPropertyScope.get(next.getScope().toLowerCase()));
			} else{
				property.setScope(EndPointPropertyScope.SYNAPSE);
			}

			executeAddValueCommand(visualEndpoint.getProperties(), property, false);
		}
		
	}

	private RegistryKeyProperty getRegistryKeyForPolicy(String wsSecPolicyKey) {
		RegistryKeyProperty regkey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
		if(wsSecPolicyKey != null){
			regkey.setKeyValue(wsSecPolicyKey);
		}else{
			regkey.setKeyValue("");
		}
		return regkey;
	}
	
	@Override
	public void createNode(FormEditor formEditor, AbstractEndpoint object) {
		ESBFormEditor endpointFormEditor = (ESBFormEditor) formEditor;
		EndpointFormPage endpointPage = (EndpointFormPage) endpointFormEditor.getFormPageForArtifact(ArtifactType.ENDPOINT);
		
		EndpointCommons endpointCommons = endpointPage.getEndpointCommons();
		
		EndpointDefinition definition = object.getDefinition();
		
		// Setting QOS
		if (definition.isReliableMessagingOn()) endpointCommons.endpointReliableMessaging.select(0);
		else endpointCommons.endpointReliableMessaging.select(1);
		
		if (definition.isSecurityOn()) endpointCommons.endpointSecurity.select(0);
		else endpointCommons.endpointSecurity.select(1);
		
		if (definition.isAddressingOn()) endpointCommons.endpointAddressing.select(0);
		else endpointCommons.endpointAddressing.select(1);
		
		// TODO further processing on QoS
		
		// Error Handling - Endpoint Suspension
		setTextValue(endpointCommons.endpointSuspendErrorCodes, definition.getSuspendErrorCodes().toString()
				.replace("[", "").replace("]", "").replace(", ", ","));
		
		setTextValue(endpointCommons.endpointSuspendInitialDuration, definition.getInitialSuspendDuration());
		
		setTextValue(endpointCommons.endpointSuspendMaxDuration, definition.getSuspendMaximumDuration());
		
		setTextValue(endpointCommons.endpointSuspendProgressFactor, definition.getSuspendProgressionFactor());
		
		// Error Handling - Endpoint Retry
		setTextValue(endpointCommons.endpointRetryErrorCodes, definition.getTimeoutErrorCodes().toString()
				.replace("[", "").replace("]", "").replace(", ", ","));
		
		setTextValue(endpointCommons.endpointRetryCount, definition.getRetriesOnTimeoutBeforeSuspend());
		
		setTextValue(endpointCommons.endpointRetryDelay, definition.getRetryDurationOnTimeout());
		
		
		// Error Handling - Endpoint Timeout
		setTextValue(endpointCommons.endpointTimeoutDuration, definition.getTimeoutDuration());
		
		if (definition.getTimeoutAction() == 100) {
			endpointCommons.endpointTimeoutAction.select(0);
		} else if (definition.getTimeoutAction() == 101) {
			endpointCommons.endpointTimeoutAction.select(1);
		} else if (definition.getTimeoutAction() == 102) {
			endpointCommons.endpointTimeoutAction.select(2);
		}
		
	}
	
	protected void setTextValue(Text textField, Object value) {
		if (value != null) {
			textField.setText(value.toString());
		}
	}
	
}
