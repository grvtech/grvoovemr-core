package com.grvtech.core.model;

import java.io.Serializable;

public class EmrPersonProperty implements Serializable {
	private String propertyName;
	private String propertyCode;
	private String propertyType; // string|number|decimal|date|list|obj|
	private String propertyValue;

}
