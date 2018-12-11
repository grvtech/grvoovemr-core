package com.grvtech.core.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grvtech.core.model.MessageRequest;
import com.grvtech.core.model.MessageResponse;
import com.grvtech.core.util.HttpUtil;

@RestController
public class UtilController {

	@RequestMapping(value = "/util/gl", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> getLicense(final HttpServletRequest request) {
		try {
			new MessageRequest(HttpUtil.getJSONFromPost(request));
		} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException
				| BadPaddingException | IOException e) {

			e.printStackTrace();
		}

		return new ResponseEntity<MessageResponse>(new MessageResponse(), HttpStatus.OK);
	}

}
