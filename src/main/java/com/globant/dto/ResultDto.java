package com.globant.dto;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;

@Data
public class ResultDto {

	private int id;
	
	private String name;
	
	private String description;
	
	private Date modified;
	
	private String resourceURI;
	
	private ArrayList<UrlDto> urls;
	
	private ThumbnailDto thumbnail;
	
	private ComicsDto comics;
	
	private StoriesDto stories;
	
	private EventsDto events;
	
	private SeriesDto series;
}
