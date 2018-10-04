package com.grvtech.core.model.administration;

import java.util.Date;
import java.util.UUID;

/*
 * can be nurse nutritionis chr md patient 
 * 
 * */

public class UserGroup {
	private int idgroup;
	private String codegroup;
	private String namegroup;
	private UUID uuidgroup;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;

}
