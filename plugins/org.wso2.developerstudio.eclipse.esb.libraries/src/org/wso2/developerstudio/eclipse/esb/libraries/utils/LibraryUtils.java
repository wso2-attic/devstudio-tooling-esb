/*
 * Copyright (c) 2011-2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.esb.libraries.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.wso2.developerstudio.eclipse.esb.libraries.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.ide.EclipseUtils;


public class LibraryUtils {
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	public static final String ECLIPSE_WORKSPACE_PATH="ECLIPSE_WORKSPACE";
	
	public static String abdera_wso2vXX_jar = "abdera_1.0.0.wso2v3.jar"; 	
	public static String axiom_1_2_11_wso2vXX_jar = "axiom_1.2.11.wso2v11.jar"; 
	public static String axis2_1_6_1_wso2vXX_jar = "axis2_1.6.1.wso2v20.jar";
	public static String httpcore_4_3_0_wso2vXX_jar = "httpcore_4.3.3.wso2v1.jar";
	public static String woden_1_0_0_M8_wso2vXX_jar = "woden_1.0.0.M9-wso2v1.jar";
	public static String synapse_core_2_1_7_wso2vXX_jar = "synapse-core_2.1.7.wso2v15.jar";
		
	public static String commons_codec_wso2vXX_jar = "commons-codec_1.4.0.wso2v1.jar"; 
	public static String commons_httpclient_wso2vXX_jar = "commons-httpclient_3.1.0.wso2v3.jar"; 
	public static String commons_io_wso2vXX_jar = "commons-io_2.4.0.wso2v1.jar"; 
	public static String commons_loggingwso2vXX_jar = "commons-logging-1.1.1.jar";	
	
	public static String geronimo_stax_api_wso2vXX_jar = "geronimo-stax-api_1.0_spec_1.0.1.wso2v2.jar"; 
	public static String neethi_wso2vXX_jar = "neethi_2.0.4.wso2v5.jar"; 
	public static String not_yet_commons_ssl_wso2vXX_jar = "not-yet-commons-ssl-0.3.9.jar"; 	
	public static String wsdl4j_wso2vXX_jar = "wsdl4j_1.6.2.wso2v4.jar"; 
	public static String XmlSchema_wso2vXX_jar = "XmlSchema_1.4.7.wso2v3.jar"; 
	
	public static String carbon_registry_api_xxx_jar = "org.wso2.carbon.registry.api_4.4.7.jar";
	public static String carbon_registry_core_xxx_jar = "org.wso2.carbon.registry.core_4.4.7.jar";	
	public static String carbon_dataservices_core_xxx_jar ="org.wso2.carbon.dataservices.core_4.2.0.jar";
	
	public static String eclips_osgi_xxx_jar ="org.eclipse.osgi_3.9.1.v20130814-1242.jar";
												
	 	
	public static File getDependencyPath(String dependencyName, boolean isRelativePath){
		String dependencyPath = getLibLocation() + dependencyName;  
		URL resource = getResourceURL(dependencyPath);
		return getDependencyPath(resource,isRelativePath);
	}

	public static File getDependencyPath(String dependencyName){
		return getDependencyPath(dependencyName,true);
	}
	
	public static URL getResourceURL(String dependencyPath) {
		return Platform.getBundle(Activator.PLUGIN_ID).getResource(dependencyPath);
	}

	public static File getDependencyPath(URL resource) {
		return getDependencyPath(resource,true);
	}
	
	public static File getDependencyPath(URL resource, boolean isRelativePath) {
		if (resource!=null) {
			IPath path = Activator.getDefault().getStateLocation();
			IPath libFolder = path.append("lib");
			String[] paths = resource.getFile().split("/");
			IPath library = libFolder.append(paths[paths.length - 1]);
			File libraryFile = library.toFile();
			if (!libraryFile.exists()) {
				try {
					writeToFile(libraryFile, resource.openStream());
				} catch (IOException e) {
					log.error(e);
					return null;
				}
			}
			if (isRelativePath) {
				IPath relativePath = EclipseUtils
						.getWorkspaceRelativePath(library);
				relativePath = new Path(ECLIPSE_WORKSPACE_PATH)
						.append(relativePath);
				return relativePath.toFile();
			} else {
				return library.toFile();
			}
		} else{
			log.error("the requested resource does not exist in library path");
			return null;
		}
	}

	private static String getLibLocation() {
		return "lib/";
	} 
	
	private static void writeToFile(File file, InputStream stream) throws IOException{
		file.getParentFile().mkdirs();
	    OutputStream out=new FileOutputStream(file);
	    byte buf[]=new byte[1024];
	    int len;
	    while((len=stream.read(buf))>0)
	    	out.write(buf,0,len);
	    out.close();
	    stream.close();
	}

}
