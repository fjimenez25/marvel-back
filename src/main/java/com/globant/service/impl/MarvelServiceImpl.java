package com.globant.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

import com.globant.api.MarvelApi;
import com.globant.dto.ResponseDto;
import com.globant.entity.Bitacora;
import com.globant.repository.BitacoraRepository;
import com.globant.service.MarvelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MarvelServiceImpl implements MarvelService{

	@Autowired
	private MarvelApi marvelApi;
	
	@Autowired
	private BitacoraRepository bitacoraRepository;
	
	private String baseUrl = "https://gateway.marvel.com:443/v1/public/characters";
	
	
	@Override
	public ResponseDto getMarvelCharacters() {
		
		
		String url = baseUrl.concat("?orderBy=modified&apikey=831197e178cd630551c03e6b9b8e1c65&hash=d0153cecda67869bf2b554fe2dd18b63&ts=1");
		ResponseEntity<ResponseDto> responseEntity;
		
		try {			
			responseEntity = (ResponseEntity<ResponseDto>) marvelApi.call(ResponseDto.class, url, HttpMethod.GET, null);
			
			log.info("body {}",responseEntity.getBody());
			
			
			Bitacora b = new Bitacora();
			b.setServiceName("characters");
			b.setDate(new Date());			
			bitacoraRepository.save(b);
		
			return responseEntity.getBody();
			
		} catch (RestClientResponseException e) {
			log.error("An error occurred when calling: {} ERROR: {}", url, e.getResponseBodyAsString());            
            throw e;
		}
		
					
	}


	@Override
	public ResponseDto getMarvelCharactersByCharacter(String character) {
		
				
		String url = baseUrl.concat(String.format("/%s?apikey=831197e178cd630551c03e6b9b8e1c65&hash=d0153cecda67869bf2b554fe2dd18b63&ts=1", character));
		ResponseEntity<ResponseDto> responseEntity;
		
		try {
			responseEntity = (ResponseEntity<ResponseDto>) marvelApi.call(ResponseDto.class, url, HttpMethod.GET, null);
			
			log.info("body {}",responseEntity.getBody());
			
			
			Bitacora b = new Bitacora();
			b.setServiceName("characters/".concat(character));
			b.setDate(new Date());			
			bitacoraRepository.save(b);
		
			return responseEntity.getBody();
			
		} catch (RestClientResponseException e) {
			log.error("An error occurred when calling: {} ERROR: {}", url, e.getResponseBodyAsString());            
            throw e;
		}
		
		
	}

}
