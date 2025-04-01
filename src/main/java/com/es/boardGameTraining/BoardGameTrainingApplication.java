package com.es.boardGameTraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BoardGameTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardGameTrainingApplication.class, args);
	}

	@Bean // Creacion mas explicita que el @Autowired
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
