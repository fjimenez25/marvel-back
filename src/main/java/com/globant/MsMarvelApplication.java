package com.globant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.globant.api"})
@ComponentScan(basePackages = {"com.globant"})
//@Configuration
//@EnableAutoConfiguration
@EntityScan(basePackages = {"com.globant.entity"})
@EnableJpaRepositories(basePackages = "com.globant.repository")
public class MsMarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsMarvelApplication.class, args);
	}

}
