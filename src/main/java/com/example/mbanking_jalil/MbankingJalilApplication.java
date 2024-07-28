package com.example.mbanking_jalil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MbankingJalilApplication {

	public static void main(String[] args) {
		SpringApplication.run(MbankingJalilApplication.class, args);
	}

}
