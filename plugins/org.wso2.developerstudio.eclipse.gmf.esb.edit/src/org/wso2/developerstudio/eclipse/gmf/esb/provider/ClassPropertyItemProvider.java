/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.provider;

import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.wso2.developerstudio.eclipse.gmf.esb.ClassProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.LogProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.EEFPropertyViewUtil;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.gmf.esb.ClassProperty} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassPropertyItemProvider extends AbstractNameValueExpressionPropertyItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ClassPropertyItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

        }
        return itemPropertyDescriptors;
    }

    /**
     * This returns ClassProperty.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/ClassProperty"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */

    @Override
    public String getText(Object object) {
        String propertyName = ((ClassProperty)object).getPropertyName();
        String propertyNameLabel = WordUtils.abbreviate(propertyName.toString(), 8, 10, " ...");
        String propertyValueType = ((ClassProperty)object).getPropertyValueType().toString();
        String propertyValueLabel = ((ClassProperty)object).getPropertyValue();
        String propertyExpressionLabel = ((ClassProperty)object).getPropertyExpression().toString();

        if (propertyValueType.equals(PropertyValueType.LITERAL.getName())) {
            return propertyName == null || propertyName.length() == 0 ?
                getString("_UI_ClassProperty_type") :
                    EEFPropertyViewUtil.spaceFormat(getString("_UI_ClassProperty_type")) +
                    EEFPropertyViewUtil.spaceFormat(propertyNameLabel) +
                    EEFPropertyViewUtil.spaceFormat(propertyValueLabel);
        } else {
            return propertyName == null || propertyName.length() == 0 ?
                getString("_UI_ClassProperty_type") :
                    EEFPropertyViewUtil.spaceFormat(getString("_UI_ClassProperty_type")) +
                    EEFPropertyViewUtil.spaceFormat(propertyNameLabel) +
                    EEFPropertyViewUtil.spaceFormat(propertyExpressionLabel);
        }
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */

    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

}
