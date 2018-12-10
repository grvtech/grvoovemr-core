package com.grvtech.core.model;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Iterator;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.grvtech.core.model.administration.Organization;
import com.grvtech.core.service.administration.IOrganizationService;
import com.grvtech.core.util.CryptoUtil;

public class MessageRequest {
	private UUID uuidorganization;
	private UUID uuidsession;
	private String action; // for logging and tracing
	private ObjectNode elements;

	@Autowired
	ApplicationContext context;

	@Autowired
	IOrganizationService orgservice;

	public MessageRequest(JsonNode jn) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		this.action = jn.get("action").asText();
		this.uuidsession = UUID.fromString(jn.get("uuidsession").asText());
		this.uuidorganization = UUID.fromString(jn.get("uuidorganization").asText());
		Organization organization = orgservice.getOrganizationByUUID(this.uuidorganization);
		JsonNode elems = jn.get("elements");
		this.elements = mapper.createObjectNode();
		Iterator<String> fieldNames = elems.fieldNames();
		String cryptoKey = organization.getLicence();
		if (cryptoKey.equals("0")) {
			cryptoKey = this.action;
		}
		while (fieldNames.hasNext()) {
			String fieldName = fieldNames.next();
			this.elements.put(fieldName, CryptoUtil.decrypt(cryptoKey, elems.get(fieldName).asText()));
		}
	}

	public MessageRequest() {
		super();
	}

	public MessageRequest(String uuidorganization, String uuidsession, String action, ObjectNode elements) {
		super();
		this.uuidorganization = UUID.fromString(uuidorganization);
		this.uuidsession = UUID.fromString(uuidsession);
		this.action = action;
		this.elements = elements;
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

}
