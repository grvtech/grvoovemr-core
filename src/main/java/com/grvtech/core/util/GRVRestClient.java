package com.grvtech.core.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.grvtech.core.model.MessageRequest;
import com.grvtech.core.model.MessageResponse;

public class GRVRestClient {

	static RestTemplate restTemplate = new RestTemplate();
	
	public static MessageResponse postRequest(String url, MessageRequest messageRequest) {
		MessageResponse result = new MessageResponse();
		HttpHeaders headers = new HttpHeaders();
		headers.set("AppLicence", "your value");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<MessageResponse> respEntity = restTemplate.exchange(url, HttpMethod.POST, entity, MessageResponse.class);
		result = respEntity.getBody();
		return result;
	} 
	
}
