/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public interface OperationPropertiesEditionPart {

	/**
	 * @return the OperationName
	 * 
	 */
	public String getOperationName();

	/**
	 * Defines a new OperationName
	 * @param newValue the new OperationName to set
	 * 
	 */
	public void setOperationName(String newValue);




	/**
	 * Init the params
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initParams(ReferencesTableSettings settings);

	/**
	 * Update the params
	 * @param newValue the params to update
	 * 
	 */
	public void updateParams();

	/**
	 * Adds the given filter to the params edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToParams(ViewerFilter filter);

	/**
	 * Adds the given filter to the params edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToParams(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the params table
	 * 
	 */
	public boolean isContainedInParamsTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
