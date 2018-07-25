package com.grvtech.core.model;

import java.io.Serializable;

public class EmrPersonProperty implements Serializable {
	private String propertyName;
	private String propertyCode;
	private String propertyType; // string|number|decimal|date|list|obj|
	private String propertyValue;

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName
	 *            the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	/**
	 * @return the propertyCode
	 */
	public String getPropertyCode() {
		return propertyCode;
	}

	/**
	 * @param propertyCode
	 *            the propertyCode to set
	 */
	public void setPropertyCode(String propertyCode) {
		this.propertyCode = propertyCode;
	}

	/**
	 * @return the propertyType
	 */
	public String getPropertyType() {
		return propertyType;
	}

	/**
	 * @param propertyType
	 *            the propertyType to set
	 */
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	/**
	 * @return the propertyValue
	 */
	public String getPropertyValue() {
		return propertyValue;
	}

	/**
	 * @param propertyValue
	 *            the propertyValue to set
	 */
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

}
