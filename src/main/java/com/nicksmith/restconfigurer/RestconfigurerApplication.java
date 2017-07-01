package com.nicksmith.restconfigurer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class RestconfigurerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestconfigurerApplication.class, args);
	}
}
