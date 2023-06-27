package com.globant.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class ComicsDto {

	private int available;
	
	private int returned;
	
	private String collectionURI;
	
	private ArrayList<ItemDto> items;
}
