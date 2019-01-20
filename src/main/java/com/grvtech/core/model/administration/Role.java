package com.grvtech.core.model.administration;

import java.util.Date;
import java.util.List;
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
	private List<Action> rights;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int idrole, UUID uuidrole, String name, String code, Date created, Date modified, UUID createdBy, UUID modifiedBy, List<Action> rights) {
		super();
		this.idrole = idrole;
		this.uuidrole = uuidrole;
		this.name = name;
		this.code = code;
		this.created = created;
		this.modified = modified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.rights = rights;
	}
	/**
	 * @return the idrole
	 */
	public int getIdrole() {
		return idrole;
	}
	/**
	 * @param idrole
	 *            the idrole to set
	 */
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	/**
	 * @return the uuidrole
	 */
	public UUID getUuidrole() {
		return uuidrole;
	}
	/**
	 * @param uuidrole
	 *            the uuidrole to set
	 */
	public void setUuidrole(UUID uuidrole) {
		this.uuidrole = uuidrole;
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
	/**
	 * @return the rights
	 */
	public List<Action> getRights() {
		return rights;
	}
	/**
	 * @param rights
	 *            the rights to set
	 */
	public void setRights(List<Action> rights) {
		this.rights = rights;
	}

}
