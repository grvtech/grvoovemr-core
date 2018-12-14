package com.grvtech.core.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grvtech.core.model.MessageRequest;
import com.grvtech.core.model.MessageResponse;
import com.grvtech.core.model.administration.Organization;
import com.grvtech.core.service.administration.IOrganizationService;

@RestController
public class UtilController {

	@Autowired
	IOrganizationService orgservice;

	@RequestMapping(value = "/util/gl", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> getLicense(final HttpServletRequest request) {
		MessageResponse mres = new MessageResponse(false, new MessageRequest(), new HashMap<>());
		try {
			MessageRequest mreq = new MessageRequest(request);
			HashMap<String, String> map = new HashMap<>();
			Organization organization = orgservice.getOrganizationByUUID(mreq.getUuidorganization());
			map.put("licence", organization.getLicence());
			mres = new MessageResponse(true, mreq, map);

		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<MessageResponse>(mres, HttpStatus.OK);
	}

}
