package com.grvtech.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grvtech.core.model.MessageRequest;
import com.grvtech.core.model.MessageResponse;
import com.grvtech.core.model.administration.User;
import com.grvtech.core.tools.HttpUtil;

@RestController
public class UtilController {

	@RequestMapping(value = "/util/gl", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> getLicense(final HttpServletRequest request) {
		MessageRequest mreq = new MessageRequest(HttpUtil.getJSONFromPost(request));

		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

}
