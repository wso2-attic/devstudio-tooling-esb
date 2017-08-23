/*
 * Copyright 2012-2017 WSO2, Inc. (http://wso2.com)
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.synapse.endpoints.Endpoint;
import org.apache.synapse.mediators.base.SequenceMediator;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CacheSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbNode;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformationInfo;
import org.wso2.developerstudio.eclipse.gmf.esb.persistence.TransformerException;

/**
 * Cache mediator transformer 
 */
public class CacheMediatorTransformer extends AbstractEsbNodeTransformer {

	public void transform(TransformationInfo information, EsbNode subject)
			throws TransformerException {
		
		//Fixing DEVTOOLEI-1120
		information.getParentSequence().addChild(createNewCacheMediator(subject,information));
		
		/**
		 *  Transform the Cache Mediator output data flow path.
		 */
		doTransform(information,
				((CacheMediator) subject).getOutputConnector());		
	}

	public void createSynapseObject(TransformationInfo info, EObject subject,
			List<Endpoint> endPoints) {
		
	}

	public void transformWithinSequence(TransformationInfo information,
			EsbNode subject, SequenceMediator sequence) throws TransformerException {

		//Fixing DEVTOOLEI-1120
		sequence.addChild(createNewCacheMediator(subject,information));
		doTransformWithinSequence(information,((CacheMediator) subject).getOutputConnector().getOutgoingLink(),sequence);
		
	}
	
	private org.wso2.carbon.mediator.cache.CacheMediator createNewCacheMediator(EsbNode subject,TransformationInfo info) throws TransformerException{
		/*
		 *  Check subject.
		 */
		Assert.isTrue(subject instanceof CacheMediator, "Invalid subject.");
		CacheMediator visualCache = (CacheMediator) subject;
		/*
		 *  Configure Cache mediator.
		 */
		org.wso2.carbon.mediator.cache.CacheMediator cacheMediator = new org.wso2.carbon.mediator.cache.CacheMediator();
		setCommonProperties(cacheMediator, visualCache);
		{
			if (visualCache.getCacheAction().getValue() == 0) {
				cacheMediator.setHTTPMethodsToCache(visualCache.getCacheProtocolMethods().split(","));
				cacheMediator.setProtocolType(visualCache.getCacheProtocolType().getLiteral());
				cacheMediator.setResponseCodes(visualCache.getResponseCodes());
				cacheMediator.setMaxMessageSize(visualCache.getMaxMessageSize());
				cacheMediator.setHttpMethod("http");

				cacheMediator.setTimeout(visualCache.getCacheTimeout());
				cacheMediator.setHeadersToExcludeInHash(visualCache.getHeadersToExcludeInHash().split(","));

				if (visualCache.getHashGenerator().equals("HTTP_REQUEST_HASH_GENERATOR")) {
					org.wso2.carbon.mediator.cache.digest.DigestGenerator httpRequestHashGenerator = new org.wso2.carbon.mediator.cache.digest.HttpRequestHashGenerator();
					cacheMediator.setDigestGenerator(httpRequestHashGenerator);
				}

				cacheMediator.setInMemoryCacheSize(visualCache.getMaxEntryCount());
				cacheMediator.setCollector(false);
			}

			if (visualCache.getCacheAction().getValue() == 1) {
				cacheMediator.setCollector(true);
			}

			if (visualCache.getSequenceType().equals(CacheSequenceType.REGISTRY_REFERENCE)) {
				if (visualCache.getSequenceKey() != null) {

					RegistryKeyProperty regKeyProperty = visualCache.getSequenceKey();
					cacheMediator.setOnCacheHitRef(regKeyProperty.getKeyValue());
				}

			} else {
				SequenceMediator onCacheHitSequence = new SequenceMediator();
				TransformationInfo newOnCacheHitInfo = new TransformationInfo();
				newOnCacheHitInfo.setTraversalDirection(info.getTraversalDirection());
				newOnCacheHitInfo.setSynapseConfiguration(info.getSynapseConfiguration());
				newOnCacheHitInfo.setOriginInSequence(info.getOriginInSequence());
				newOnCacheHitInfo.setOriginOutSequence(info.getOriginOutSequence());
				newOnCacheHitInfo.setCurrentProxy(info.getCurrentProxy());
				newOnCacheHitInfo.setParentSequence(onCacheHitSequence);
				doTransform(newOnCacheHitInfo, visualCache.getOnHitOutputConnector());
				cacheMediator.setOnCacheHitSequence(onCacheHitSequence);
			}

		}
		return cacheMediator;
	}
}
