package com.grvtech.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class MessageRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 89266137555650743L;
	private UUID uuidmessage;
	private UUID uuidorganization;
	private UUID uuidsession;
	private String state; /* clear|enc */
	private ArrayList<Object> elements;
	public UUID getUuidmessage() {
		return uuidmessage;
	}
	public void setUuidmessage(UUID uuidmessage) {
		this.uuidmessage = uuidmessage;
	}
	public UUID getUuidorganization() {
		return uuidorganization;
	}
	public void setUuidorganization(UUID uuidorganization) {
		this.uuidorganization = uuidorganization;
	}
	public UUID getUuidsession() {
		return uuidsession;
	}
	public void setUuidsession(UUID uuidsession) {
		this.uuidsession = uuidsession;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public ArrayList<Object> getElements() {
		return elements;
	}
	public void setElements(ArrayList<Object> elements) {
		this.elements = elements;
	}
	public MessageRequest(UUID uuidmessage, UUID uuidorganization, UUID uuidsession, String state,
			ArrayList<Object> elements) {
		super();
		this.uuidmessage = uuidmessage;
		this.uuidorganization = uuidorganization;
		this.uuidsession = uuidsession;
		this.state = state;
		this.elements = elements;
	}
	
	
	
	

}
