package com.grvtech.core.model.administration;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.grvtech.core.model.clinical.ClinicalCategories;

public class Application {
	private int idapplication;
	private UUID uuidapplication;
	private UUID uuidorganisation;
	private String licence;
	private Date lws;
	private Date lwe;
	private Date created;
	private Date modified;
	private UUID createdBy;
	private UUID modifiedBy;
	private ArrayList<ClinicalCategories> categories;
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Application(int idapplication, UUID uuidapplication, UUID uuidorganisation, String licence, Date lws, Date lwe, Date created, Date modified, UUID createdBy, UUID modifiedBy,
			ArrayList<ClinicalCategories> categories) {
		super();
		this.idapplication = idapplication;
		this.uuidapplication = uuidapplication;
		this.uuidorganisation = uuidorganisation;
		this.licence = licence;
		this.lws = lws;
		this.lwe = lwe;
		this.created = created;
		this.modified = modified;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.categories = categories;
	}
	/**
	 * @return the idapplication
	 */
	public int getIdapplication() {
		return idapplication;
	}
	/**
	 * @param idapplication
	 *            the idapplication to set
	 */
	public void setIdapplication(int idapplication) {
		this.idapplication = idapplication;
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
	 * @return the uuidorganisation
	 */
	public UUID getUuidorganisation() {
		return uuidorganisation;
	}
	/**
	 * @param uuidorganisation
	 *            the uuidorganisation to set
	 */
	public void setUuidorganisation(UUID uuidorganisation) {
		this.uuidorganisation = uuidorganisation;
	}
	/**
	 * @return the licence
	 */
	public String getLicence() {
		return licence;
	}
	/**
	 * @param licence
	 *            the licence to set
	 */
	public void setLicence(String licence) {
		this.licence = licence;
	}
	/**
	 * @return the lws
	 */
	public Date getLws() {
		return lws;
	}
	/**
	 * @param lws
	 *            the lws to set
	 */
	public void setLws(Date lws) {
		this.lws = lws;
	}
	/**
	 * @return the lwe
	 */
	public Date getLwe() {
		return lwe;
	}
	/**
	 * @param lwe
	 *            the lwe to set
	 */
	public void setLwe(Date lwe) {
		this.lwe = lwe;
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
	 * @return the categories
	 */
	public ArrayList<ClinicalCategories> getCategories() {
		return categories;
	}
	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(ArrayList<ClinicalCategories> categories) {
		this.categories = categories;
	}

}
