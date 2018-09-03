package com.grvtech.core.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Patient extends Person {
	private UUID uuidPatient;
	private int idPatient;
	private boolean active;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	private ArrayList<EmrPersonProperty> infoPatient;

}
