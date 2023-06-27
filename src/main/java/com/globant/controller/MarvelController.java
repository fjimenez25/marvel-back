package com.globant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import com.globant.dto.ResponseDto;
import com.globant.entity.Bitacora;
import com.globant.service.MarvelService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/demo")
public class MarvelController {

	@Autowired
	private MarvelService service;
	
	
	@GetMapping(value = "/public/characters", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    @ResponseStatus(HttpStatus.OK)
	public ResponseDto getMarvelCharacters() {
		
		log.info("Calling getMarvelCharacters...");
		
		return service.getMarvelCharacters();	
		
	}
	
	
	
	@GetMapping(value = "/public/characters/{character}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    @ResponseStatus(HttpStatus.OK)
	public ResponseDto getMarvelCharacterByCharacter(@PathVariable("character") String character) {
		
		log.info("Calling getMarvelCharacterByCharacter...");
		
		return service.getMarvelCharactersByCharacter(character);
		
		
	}
	
	
	@GetMapping(value = "/public/bitacora", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
    @ResponseStatus(HttpStatus.OK)
	public Iterable<Bitacora> getBitacora() {
		
		log.info("Calling getBitacora...");
		
		return service.getBitacora();
		
		
	}
	
	
	
	
}
