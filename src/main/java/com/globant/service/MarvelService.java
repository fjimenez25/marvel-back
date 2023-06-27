package com.globant.service;

import java.util.List;

import com.globant.dto.ResponseDto;
import com.globant.entity.Bitacora;

public interface MarvelService {

	
	public ResponseDto getMarvelCharacters();
	
	public ResponseDto getMarvelCharactersByCharacter(String character);
	
	public Iterable<Bitacora> getBitacora();
	
}
