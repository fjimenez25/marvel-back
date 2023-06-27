package com.globant.dto;

import lombok.Data;

@Data
public class ResponseDto {

	
	private int code;
	
	private String status;
	
	private String copyright;
	
	private String attributionText;
	
	private String attributionHTML;
	
	private DataDto data;
	
	private String etag;
}
