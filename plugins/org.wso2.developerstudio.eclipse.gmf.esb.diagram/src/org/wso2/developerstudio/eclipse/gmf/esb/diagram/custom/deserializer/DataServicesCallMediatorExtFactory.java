 /*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.deserializer;

import java.util.Properties;
import javax.xml.namespace.QName;
import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediatorFactory;
import org.wso2.micro.integrator.mediator.dataservice.DataServiceCallMediator;

public class DataServicesCallMediatorExtFactory extends DataServiceCallMediatorFactory {

    private static DataServicesCallMediatorExtFactory instance;

    private DataServicesCallMediatorExtFactory() {

    }

    public static DataServicesCallMediatorExtFactory getInstance() {
        if (instance == null) {
            instance = new DataServicesCallMediatorExtFactory();
        }
        return instance;
    }

    @Override
    public Mediator createSpecificMediator(OMElement omElement, Properties properties) {

        QName ATT_SERVICE_NAME = new QName("serviceName");
        QName ATT_SOURCE = new QName("source");
        QName ATT_TARGET = new QName("target");

        DataServiceCallMediator dataServiceCallMediator = new DataServiceCallMediator();
        processAuditStatus(dataServiceCallMediator, omElement);

        OMAttribute serviceName = omElement.getAttribute(ATT_SERVICE_NAME);
        OMAttribute sourceType = omElement.getAttribute(ATT_SOURCE);
        OMAttribute targetType = omElement.getAttribute(ATT_TARGET);

        if (serviceName != null) {
            dataServiceCallMediator.setDsName(serviceName.getAttributeValue());
        }

        if (sourceType != null) {
            dataServiceCallMediator.setSourceType(sourceType.getAttributeValue());
        }

        if (targetType != null) {
            dataServiceCallMediator.setTargetType(targetType.getAttributeValue());
        }

        return dataServiceCallMediator;
    }
}
