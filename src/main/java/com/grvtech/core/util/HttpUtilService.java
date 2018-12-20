package com.grvtech.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grvtech.core.model.administration.Organization;
import com.grvtech.core.service.administration.IOrganizationService;

@Service
public class HttpUtilService {

	@Autowired
	IOrganizationService orgservice;

	public JsonNode getJSONFromPost(HttpServletRequest request) {
		JsonNode result = null;
		BufferedReader reader;
		try {
			reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			while (line != null) {
				sb.append(line);
				line = reader.readLine();

			}
			reader.close();

			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getFactory();
			JsonParser parser = factory.createParser(sb.toString());

			System.out.println("json from request : " + sb.toString());

			result = mapper.readTree(parser);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Organization getOrganisation(HttpServletRequest request) {
		Organization result = new Organization();

		Enumeration<String> hns = request.getHeaderNames();

		while (hns.hasMoreElements()) {
			String hn = hns.nextElement();
			System.out.println("header " + hn + "     value " + request.getHeader(hn));
		}

		String organizationStr = request.getHeader("organization");
		System.out.println("Organization : " + organizationStr);
		if (organizationStr != null) {
			result = orgservice.getOrganizationByUUID(UUID.fromString(organizationStr));
		}
		return result;
	}

}
