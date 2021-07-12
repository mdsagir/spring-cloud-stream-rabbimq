package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootApplication
public class RabbitConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitConsumerApplication.class, args);
	}

	@Bean
	public Consumer<String> email() {
		return mail -> log.info("Email sending to "+mail);
	}

	@Bean
	public Consumer<String> notification() {
		return msg -> log.info("Received Notification "+msg);
	}

	@Bean
	public Function<Integer,String> order() {
		return orderId -> {
			log.info("Order received  : {}", orderId);
			String trackedId = getTrackedId().get();
			log.info("Tracked Id {}",trackedId);
			return trackedId;
		};
	}
	public Supplier<String> getTrackedId() {
		return () -> {
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 18) { // length of the random string.
				int index = (int) (rnd.nextFloat() * SALTCHARS.length());
				salt.append(SALTCHARS.charAt(index));
			}
			return salt.toString();
		};
	}

}