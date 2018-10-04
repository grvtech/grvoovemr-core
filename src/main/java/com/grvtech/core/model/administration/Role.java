package com.grvtech.core.model.administration;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Role {
	private int idrole;
	private UUID uuidrole;
	private String name;
	private String code;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	private ArrayList<Action> rights;
}
