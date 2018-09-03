package com.grvtech.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class EmrPersonProperty implements Serializable {
	private int idproperty;
	private String propertyname;
	private String propertycode;
	private String propertynode; //person, patient, practician, relatedperson,   
	private String propertytype; // string|number|decimal|date|list|obj|
	private String propertyvalue;
	private int propertyorder;
	private boolean visible;
	private Date created;
	private Date modified;
	private UUID uuidnode;   //uuid of person or patient or practition or related person
	public int getIdproperty() {
		return idproperty;
	}
	public void setIdproperty(int idproperty) {
		this.idproperty = idproperty;
	}
	public String getPropertyname() {
		return propertyname;
	}
	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}
	public String getPropertycode() {
		return propertycode;
	}
	public void setPropertycode(String propertycode) {
		this.propertycode = propertycode;
	}
	public String getPropertynode() {
		return propertynode;
	}
	public void setPropertynode(String propertynode) {
		this.propertynode = propertynode;
	}
	public String getPropertytype() {
		return propertytype;
	}
	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}
	public String getPropertyvalue() {
		return propertyvalue;
	}
	public void setPropertyvalue(String propertyvalue) {
		this.propertyvalue = propertyvalue;
	}
	public int getPropertyorder() {
		return propertyorder;
	}
	public void setPropertyorder(int propertyorder) {
		this.propertyorder = propertyorder;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public UUID getUuidnode() {
		return uuidnode;
	}
	public void setUuidnode(UUID uuidnode) {
		this.uuidnode = uuidnode;
	}
	public EmrPersonProperty(int idproperty, String propertyname, String propertycode, String propertynode,
			String propertytype, String propertyvalue, int propertyorder, boolean visible, Date created, Date modified,
			UUID uuidnode) {
		super();
		this.idproperty = idproperty;
		this.propertyname = propertyname;
		this.propertycode = propertycode;
		this.propertynode = propertynode;
		this.propertytype = propertytype;
		this.propertyvalue = propertyvalue;
		this.propertyorder = propertyorder;
		this.visible = visible;
		this.created = created;
		this.modified = modified;
		this.uuidnode = uuidnode;
	}
	public EmrPersonProperty() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
