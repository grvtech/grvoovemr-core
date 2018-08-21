package com.grvtech.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grvtech.core.model.User;
import com.grvtech.core.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userservice;

	@RequestMapping("/user/{userId}")
	public ResponseEntity<User> getUser(@PathVariable int userId) {
		User u1 = userservice.getUserById(userId);
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

}
