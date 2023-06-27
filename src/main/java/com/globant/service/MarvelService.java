package com.globant.service;

import com.globant.dto.ResponseDto;

public interface MarvelService {

	
	public ResponseDto getMarvelCharacters();
	
	public ResponseDto getMarvelCharactersByCharacter(String character);
	
}
