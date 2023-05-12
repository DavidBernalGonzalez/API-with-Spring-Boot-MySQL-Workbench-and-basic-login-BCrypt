package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HackathonBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonBackApplication.class, args);
	}

}
