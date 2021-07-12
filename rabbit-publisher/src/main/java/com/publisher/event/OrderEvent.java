package com.publisher.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Slf4j
@Configuration
public class OrderEvent {


    @Bean
    public Supplier<String> sendNotification() {
        return () -> {
            String i = getNotification().get();
            if (Objects.nonNull(i)) {
                log.info("Sending " + i);
                return i;
            }
            return null;
        };
    }

    @Bean
    public Consumer<String> packed() {
        return trackedId -> log.info("Order trackedId " + trackedId);
    }

    public Supplier<String> getNotification() {
        return () -> {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 18) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            //return salt.toString();
            return null;
        };
    }

//
//    @Bean
//    public Consumer<String> receive2() {
//        return msg -> log.info("Received2 "+msg);
//    }

        /*private final AtomicInteger count = new AtomicInteger(0);

        @Bean
        public Function<Integer, String> accumulate() {
            return payload -> "Current value: " + payload + ", Total: " + this.count.addAndGet(payload);
        }*/

}
