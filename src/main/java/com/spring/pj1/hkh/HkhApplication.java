package com.spring.pj1.hkh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HkhApplication {

	public static void main(String[] args) {
		SpringApplication.run(HkhApplication.class, args);
	}

}
