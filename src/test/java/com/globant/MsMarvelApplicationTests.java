package com.globant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.globant.controller.MarvelController;

@SpringBootTest
class MsMarvelApplicationTests {

	@Autowired
	private MarvelController marvelController;
	@Autowired
	private ApplicationContext context;
	
	
	@Test
	void contextLoads() {
		MsMarvelApplication.main(new String[] {});
		assertThat(marvelController).isNotNull();
		assertThat(this.context).isNotNull();
		
		
	}

}
