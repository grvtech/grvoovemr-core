package com.grvtech.core.model.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Person {
	private int idperson;
	private UUID uuidperson;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	private ArrayList<EmrProperty> epp;

}
