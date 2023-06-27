package com.globant.util;

import java.util.Date;

import com.globant.dto.ResponseDto;
import com.globant.entity.Bitacora;

public class TestConstants {


	public static ResponseDto getValidResponseDto() {
	
		ResponseDto response = new ResponseDto();
		response.setCode(1);
		response.setCopyright("copyright");
		response.setEtag("etag");
				
		return response;
		
	}
	
	
	public static ResponseDto getValidBitacora() {
		
		Bitacora b = new Bitacora();
		
		b.setServiceName("characters");
		b.setDate(new Date());			
		b.setId(1);
		
		return null;
		
	}
	
	
	
}
