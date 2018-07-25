package com.grvtech.core.tools;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grvtech.core.model.User;
import com.grvtech.core.service.IUserService;

@RestController
public class DBToolController {

	@Autowired
	private DBTool db;

	@Autowired
	private IUserService userservice;

	@RequestMapping("/tools/createtable")
	public ResponseEntity<String> createtable() {
		// db = new DBTool();
		db.createTables();
		return new ResponseEntity<String>("good", HttpStatus.OK);
	}

	@RequestMapping("/tools/addusers")
	public ResponseEntity<User> addusers() {

		User u1 = new User(1, UUID.randomUUID(), UUID.randomUUID(), "radu", "radu", "radu@grvtech.ca", "1234", "", "");
		User u2 = new User(1, UUID.randomUUID(), UUID.randomUUID(), "victor", "victor", "victor@grvtech.ca", "1234", "",
				"");
		User u3 = new User(1, UUID.randomUUID(), UUID.randomUUID(), "gabor", "gabor", "gabor@grvtech.ca", "1234", "",
				"");
		userservice.addUser(u1);
		userservice.addUser(u2);
		userservice.addUser(u3);
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}
}
