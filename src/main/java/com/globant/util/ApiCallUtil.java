package com.globant.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApiCallUtil {

	@Autowired
	private RestTemplate restTemplate;
	

	public <T extends Class> ResponseEntity<?> call(T responseType, String url, HttpMethod method, HttpEntity<?> entity) {
	
		log.info("Call api with url {}", (url));
		
		ResponseEntity<T> responseEntity;
	
		responseEntity = restTemplate.exchange(url, method, entity, responseType);
					
		return responseEntity;
	}
	
}
