package com.grvtech.core.model.administration;

import java.util.Date;
import java.util.UUID;

/*
 * can be nurse nutritionis chr md patient 
 * 
 * */

public class Group {
	private int idgroup;
	private UUID uuidgroup;
	private String code;
	private String name;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(int idgroup, UUID uuidgroup, String code, String name, Date created, Date modified, UUID createdBy, UUID modifiedBy) {
		super();
		this.idgroup = idgroup;
		this.uuidgroup = uuidgroup;
		this.code = code;
		this.name = name;
		this.created = created;
		this.modified = modified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
	}
	/**
	 * @return the idgroup
	 */
	public int getIdgroup() {
		return idgroup;
	}
	/**
	 * @param idgroup
	 *            the idgroup to set
	 */
	public void setIdgroup(int idgroup) {
		this.idgroup = idgroup;
	}
	/**
	 * @return the uuidgroup
	 */
	public UUID getUuidgroup() {
		return uuidgroup;
	}
	/**
	 * @param uuidgroup
	 *            the uuidgroup to set
	 */
	public void setUuidgroup(UUID uuidgroup) {
		this.uuidgroup = uuidgroup;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}
	/**
	 * @param modified
	 *            the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	/**
	 * @return the createdBy
	 */
	public UUID getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the modifiedBy
	 */
	public UUID getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(UUID modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
