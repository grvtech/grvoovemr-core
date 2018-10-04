package com.grvtech.core.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

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
import com.grvtech.core.model.administration.User;
import com.grvtech.core.service.UserService;
import com.grvtech.core.util.CryptoUtil;

@RestController
public class UserController {

	/*
	 * 
	 * https://www.thomasvitale.com/https-spring-boot-ssl-certificate/
	 */

	@Autowired
	private UserService userservice;

	@RequestMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User u1 = userservice.getUserById(userId);
		return new ResponseEntity<User>(u1, HttpStatus.OK);
	}

	/* getUserByUsernamePassword */
	@RequestMapping(value = "/user/gubup", method = RequestMethod.POST)
	public ResponseEntity<User> getUserByUsernamePassword(final HttpServletRequest request) {
		User ul = new User();
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
			JsonNode elements = jn.get("elements");
			JsonNode user = elements.get("username");
			JsonNode pass = elements.get("password");

			System.out.println("------------------------------");
			System.out.println("username encrypted: " + user);
			System.out.println("password encrypted: " + pass);

			String duser = CryptoUtil.decrypt("test", user.asText());
			String dpass = CryptoUtil.decrypt("test", pass.asText());
			System.out.println("username decrypted: " + duser);
			System.out.println("password decrypted: " + dpass);

			ul = userservice.getUserByUsernamePassword(duser, dpass);

		} catch (IOException e) {
			e.printStackTrace();
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

		// User u1 = userservice.getUserById(2);

		return new ResponseEntity<User>(ul, HttpStatus.OK);
	}

	/* getUserByEmailPassword */
	@RequestMapping(value = "/user/gubep", method = RequestMethod.POST)
	public ResponseEntity<User> getUserByEmailPassword(final HttpServletRequest request) {
		User ul = new User();
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
			JsonNode elements = jn.get("elements");
			JsonNode email = elements.get("email");
			JsonNode pass = elements.get("password");

			System.out.println("------------------------------");
			System.out.println("username encrypted: " + email);
			System.out.println("password encrypted: " + pass);

			String duser = CryptoUtil.decrypt("test", email.asText());
			String dpass = CryptoUtil.decrypt("test", pass.asText());
			System.out.println("username decrypted: " + duser);
			System.out.println("password decrypted: " + dpass);

			ul = userservice.getUserByEmailPassword(duser, dpass);

		} catch (IOException e) {
			e.printStackTrace();
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

		// User u1 = userservice.getUserById(2);

		return new ResponseEntity<User>(ul, HttpStatus.OK);
	}

	/* add User */
	@RequestMapping(value = "/user/addu", method = RequestMethod.POST)
	public ResponseEntity<User> addUser(final HttpServletRequest request) {
		User ul = new User();
		BufferedReader reader;
		try {

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
			JsonNode elements = jn.get("elements");
			JsonNode user = elements.get("username");
			JsonNode pass = elements.get("password");

			System.out.println("------------------------------");
			System.out.println("username encrypted: " + user);
			System.out.println("password encrypted: " + pass);

			String username = CryptoUtil.decrypt("test", user.asText());
			String password = CryptoUtil.decrypt("test", pass.asText());
			String uuiduser = CryptoUtil.decrypt("test", elements.get("uuiduser").asText());
			String uuidperson = CryptoUtil.decrypt("test", elements.get("uuidperson").asText());
			String email = CryptoUtil.decrypt("test", elements.get("email").asText());
			String pin = CryptoUtil.decrypt("test", elements.get("pin").asText());
			String logo = CryptoUtil.decrypt("test", elements.get("logo").asText());
			String securityimage = CryptoUtil.decrypt("test", elements.get("securityimage").asText());
			String authmethod = CryptoUtil.decrypt("test", elements.get("authmethod").asText());

			ul = new User(0, UUID.fromString(uuiduser), UUID.fromString(uuidperson), username, password, email, pin, logo, securityimage, authmethod);
			userservice.addUser(ul);

		} catch (IOException e) {
			e.printStackTrace();
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

		// User u1 = userservice.getUserById(2);

		return new ResponseEntity<User>(ul, HttpStatus.OK);
	}

}
