package com.grvtech.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Person {
	private UUID uuidperson;
	private int idperson;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	private ArrayList<EmrPersonProperty> epp;

}
