package com.globant.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.globant.service.MarvelService;
import com.globant.util.TestConstants;

@WebMvcTest(MarvelController.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {MarvelController.class})
class MarvelControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MarvelService service;
	
	
	//@Test
	void callMarvelTest() throws Exception {
		
		when(service.getMarvelCharacters()).thenReturn(TestConstants.getValidResponseDto());
		
		//UsernamePasswordAuthenticationToken at =  this.ge
		
		
		mockMvc.perform(get("/marvel/demo/call-api")
				//.with(us)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		
		.andExpect(status().isOk())
		
		.andDo(print());
		
		
	}
	
	
}
