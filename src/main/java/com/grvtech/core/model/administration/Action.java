package com.grvtech.core.model.administration;

import java.util.UUID;

public class Action {
	private int idaction;
	private UUID uuidaction;
	private UUID uuidapplication;
	private String name;
	private String code;
	private String description;
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Action(int idaction, UUID uuidaction, UUID uuidapplication, String name, String code, String description) {
		super();
		this.idaction = idaction;
		this.uuidaction = uuidaction;
		this.uuidapplication = uuidapplication;
		this.name = name;
		this.code = code;
		this.description = description;
	}
	/**
	 * @return the idaction
	 */
	public int getIdaction() {
		return idaction;
	}
	/**
	 * @param idaction
	 *            the idaction to set
	 */
	public void setIdaction(int idaction) {
		this.idaction = idaction;
	}
	/**
	 * @return the uuidaction
	 */
	public UUID getUuidaction() {
		return uuidaction;
	}
	/**
	 * @param uuidaction
	 *            the uuidaction to set
	 */
	public void setUuidaction(UUID uuidaction) {
		this.uuidaction = uuidaction;
	}
	/**
	 * @return the uuidapplication
	 */
	public UUID getUuidapplication() {
		return uuidapplication;
	}
	/**
	 * @param uuidapplication
	 *            the uuidapplication to set
	 */
	public void setUuidapplication(UUID uuidapplication) {
		this.uuidapplication = uuidapplication;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
