package com.globant.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class DataDto {

	private int offset;
	
	private int limit;
	
	private int total;
	
	private int count;
	
	private ArrayList<ResultDto> results;
}
