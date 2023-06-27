package com.globant.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;

//import com.globant.api.MarvelApi;
import com.globant.dto.ResponseDto;
import com.globant.entity.Bitacora;
import com.globant.repository.BitacoraRepository;
import com.globant.service.MarvelService;
import com.globant.util.ApiCallUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MarvelServiceImpl implements MarvelService{

	@Autowired
	private ApiCallUtil marvelApi;
	
	@Autowired
	private BitacoraRepository bitacoraRepository;
	
	@Value("${marvel.url-base}")
	private String baseUrl;
	
	@Value("${marvel.apikey}")
	private String apiKey;
	
	@Value("${marvel.hash}")
	private String hash;
	
	@Value("${marvel.ts}")
	private String ts;
	
	
	@Override
	public ResponseDto getMarvelCharacters() {
					
		String url = baseUrl.concat(String.format("?orderBy=modified&apikey=%s&hash=%s&ts=%s", apiKey, hash, ts));
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
				
		String url = baseUrl.concat(String.format("/%s?apikey=%s&hash=%s&ts=%s", character, apiKey, hash, ts));
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
	
	
	@Override
	public Iterable<Bitacora> getBitacora() {
									
		return bitacoraRepository.findAll();
		
	}
	
	

}
