package com.grvtech.core.model.human;

import java.util.Date;
import java.util.UUID;

public class EmrProperty {
	private int idproperty;
	private UUID uuidproperty;
	private UUID uuidpropertytype;
	private String propertyvalue;
	private int propertyorder;
	private boolean visible;
	private Date created;
	private Date modified;
	private UUID uuidperson; // uuid of person or patient or practition
	private UUID createdBy;
	private UUID modifiedBy;

}
