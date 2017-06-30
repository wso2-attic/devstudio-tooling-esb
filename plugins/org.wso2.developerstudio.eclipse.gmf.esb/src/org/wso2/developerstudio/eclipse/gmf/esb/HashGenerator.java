/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Hash Generator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getHashGenerator()
 * @model
 * @generated
 */
public enum HashGenerator implements Enumerator {
	/**
	 * The '<em><b>CARBON MEDIATOR CACHE DIGEST DOMHASH GENERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR(0, "CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR", "CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR");

	/**
	 * The '<em><b>CARBON MEDIATOR CACHE DIGEST DOMHASH GENERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CARBON MEDIATOR CACHE DIGEST DOMHASH GENERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR_VALUE = 0;

	/**
	 * An array of all the '<em><b>Hash Generator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HashGenerator[] VALUES_ARRAY =
		new HashGenerator[] {
			CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR,
		};

	/**
	 * A public read-only list of all the '<em><b>Hash Generator</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HashGenerator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Hash Generator</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HashGenerator get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HashGenerator result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hash Generator</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HashGenerator getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HashGenerator result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Hash Generator</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HashGenerator get(int value) {
		switch (value) {
			case CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR_VALUE: return CARBON_MEDIATOR_CACHE_DIGEST_DOMHASH_GENERATOR;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private HashGenerator(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //HashGenerator
