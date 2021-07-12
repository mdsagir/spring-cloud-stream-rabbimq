package com.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RabbitPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitPublisherApplication.class, args);
	}

}
