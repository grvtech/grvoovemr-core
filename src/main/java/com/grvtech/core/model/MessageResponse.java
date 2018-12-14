package com.grvtech.core.model;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.grvtech.core.model.administration.Organization;
import com.grvtech.core.service.administration.IOrganizationService;
import com.grvtech.core.util.CryptoUtil;

/*
{
	"uuidsession":"aaaaabbbb33333",
	"uuidevent":"addu",
	"state":"enc",
	"status":"success",
	"elements":[
	            "aaaaasdaedaecsecsecse",
	            "asdasdasdasdasdasdasdasd"
	]  
}


an event 

	anonymous events = everybody can do that
	event = login
		
	event = subscribe

	not anonymous 
	event  = search 
		controler resuests ......
		 
	event = view clical data vcd
			add clinical data
			edit clinical data
			delete clinical data
	
	event = view patient record
			add patient record
			edit patient record
			delete patient record
			
	event = view search patient
	
	
	authentification of event for user done on dis 
	only authentification of organisation should be done on core
	
*/

public class MessageResponse {
	private UUID uuidsession; // clear|enc
	private String status; // success|error
	private String action;
	private ObjectNode elements; // on error is empty

	@Autowired
	public IOrganizationService orgservice;

	public MessageResponse() {
		super();
		this.action = "gol";
	}

	public MessageResponse(boolean status, MessageRequest mr, HashMap<String, String> map) {
		super();
		ObjectMapper mapper = new ObjectMapper();
		this.action = mr.getAction();
		this.uuidsession = mr.getUuidsession();
		if (status) {
			this.status = "success";
		} else {
			this.status = "error";
		}
		if (this.action.equals("gol")) {
			this.status = "error";
		} else {
			this.elements = mapper.createObjectNode();
			Set<String> fieldNames = map.keySet();
			Organization org = orgservice.getOrganizationByUUID(mr.getUuidorganization());
			for (String fieldName : fieldNames) {
				try {
					this.elements.put(fieldName, CryptoUtil.encrypt(org.getLicence(), map.get(fieldName)));
				} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException | UnsupportedEncodingException
						| IllegalBlockSizeException | BadPaddingException e) {

					e.printStackTrace();
					this.status = "error";
					break;
				}
			}
		}
	}

	/**
	 * @return the uuidsession
	 */
	public UUID getUuidsession() {
		return uuidsession;
	}

	/**
	 * @param uuidsession
	 *            the uuidsession to set
	 */
	public void setUuidsession(UUID uuidsession) {
		this.uuidsession = uuidsession;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the elements
	 */
	public ObjectNode getElements() {
		return elements;
	}
	/**
	 * @param elements
	 *            the elements to set
	 */
	public void setElements(ObjectNode elements) {
		this.elements = elements;
	}

	public void setElements(HashMap<String, String> elements, String licence) {
		ObjectMapper mapper = new ObjectMapper();
		this.elements = mapper.createObjectNode();
		Set<String> fieldNames = elements.keySet();
		for (String fieldName : fieldNames) {
			try {
				this.elements.put(fieldName, CryptoUtil.encrypt(licence, elements.get(fieldName)));
			} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException | UnsupportedEncodingException
					| IllegalBlockSizeException | BadPaddingException e) {
				e.printStackTrace();
				this.status = "error";
				break;
			}
		}
	}

}
