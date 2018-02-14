/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.eclipse.gmf.esb.internal.persistence.custom;

import org.apache.axiom.om.OMElement;
import org.apache.synapse.Mediator;
import org.apache.synapse.config.xml.AbstractMediatorSerializer;

public class ClassMediatorExtSerializer extends AbstractMediatorSerializer {
	
	public OMElement serializeSpecificMediator(Mediator m) {

        if (!(m instanceof ClassMediatorExt)) {
            handleException("Unsupported mediator passed in for serialization : " + m.getType());
        }
        ClassMediatorExt mediator = (ClassMediatorExt) m;
        OMElement clazz = fac.createOMElement("class", synNS);
        saveTracingState(clazz, mediator);

        if (mediator.getMediator() != null && mediator.getMediator().getClass().getName() != null) {
            clazz.addAttribute(fac.createOMAttribute(
                "name", nullNS, mediator.getMediatorClass()));
        } else {
            handleException("Invalid class mediator. The class name is required");
        }

        super.serializeProperties(clazz, mediator.getProperties());

        return clazz;
    }

    public String getMediatorClassName() {
        return ClassMediatorExt.class.getName();
    }
}
