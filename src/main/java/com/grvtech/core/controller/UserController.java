package com.grvtech.core.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grvtech.core.model.User;
import com.grvtech.core.service.IUserService;
import com.grvtech.core.util.CryptoUtil;

@RestController
public class UserController {

	@Autowired
	private IUserService userservice;

	@RequestMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User u1 = userservice.getUserById(userId);
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/gu", method = RequestMethod.POST)
	public ResponseEntity<User> getUser(final HttpServletRequest request) {

		BufferedReader reader;
		try {

			Map<String, String[]> map = request.getParameterMap();
			ArrayList<String> iti = new ArrayList(map.keySet());
			for (int i = 0; i < iti.size(); i++) {
				String[] parts = map.get(iti.get(i));
				System.out.println(iti.get(i) + "::");
				for (int j = 0; j < parts.length; j++) {
					System.out.print(parts[j] + ";");
				}
				System.out.println();
			}

			// System.out.println("params : " + request.);
			reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				System.out.println("line body : " + line);
				sb.append(line);
				line = reader.readLine();

			}
			reader.close();
			System.out.println("------------------------------");
			System.out.println("request body : " + sb.toString());
			System.out.println("------------------------------");

			ObjectMapper mapper = new ObjectMapper();
			JsonNode jn = mapper.readTree(sb.toString());
			JsonNode user = jn.get("username");
			JsonNode pass = jn.get("password");

			System.out.println("------------------------------");
			System.out.println("username encrypted: " + user.get(0));
			System.out.println("password encrypted: " + pass.get(0));
			try {
				System.out.println("username decrypted: " + CryptoUtil.decrypt("test", user.get(0).asText()));
				System.out.println("password decrypted: " + CryptoUtil.decrypt("test", pass.get(0).asText()));
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			} catch (NoSuchPaddingException e) {
				e.printStackTrace();
			} catch (InvalidAlgorithmParameterException e) {
				e.printStackTrace();
			} catch (IllegalBlockSizeException e) {
				e.printStackTrace();
			} catch (BadPaddingException e) {
				e.printStackTrace();
			}

			System.out.println("------------------------------");

		} catch (IOException e) {
			e.printStackTrace();
		}

		User u1 = userservice.getUserById(2);
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

}
