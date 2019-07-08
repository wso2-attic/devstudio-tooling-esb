/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

import org.eclipse.emf.common.util.Enumerator;

// Start of user code for imports



// End of user code

/**
 * 
 * 
 */
public interface ParamPropertiesEditionPart {

	/**
	 * @return the paramName
	 * 
	 */
	public String getParamName();

	/**
	 * Defines a new paramName
	 * @param newValue the new paramName to set
	 * 
	 */
	public void setParamName(String newValue);


	/**
	 * @return the paramValue
	 * 
	 */
	public String getParamValue();

	/**
	 * Defines a new paramValue
	 * @param newValue the new paramValue to set
	 * 
	 */
	public void setParamValue(String newValue);



	/**
	* @return the type
	* 
	*/
	public String getType();

	/**
	* Defines a new type
	* @param newValue the new type to set
	* 
	*/
	public void setType(String newValue);

	/**
	* @return the paramValueType
	* 
	*/
	public Enumerator getParamValueType();

	/**
	* Init the paramValueType
	* @param input the viewer input
	* @param current the current value
	*/	
	public void initParamValueType(Object input, Enumerator current);

	/**
	* Defines a new paramValueType
	* @param newValue the new paramValueType to set
	* 
	*/
	public void setParamValueType(Enumerator newValue);



	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();
	
	/**
	* @return the evauator
	* 
	*/
	public Enumerator getEvauator();

	/**
	* Init the evauator
	* @param input the viewer input
	* @param current the current value
	*/
	public void initEvauator(Object input, Enumerator current);
	
	/**
	* Defines a new evauator
	* @param newValue the new evauator to set
	* 
	*/
	public void setEvauator(Enumerator newValue);




	// Start of user code for additional methods
	
	// End of user code

}
