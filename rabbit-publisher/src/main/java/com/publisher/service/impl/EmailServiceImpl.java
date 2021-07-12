package com.publisher.service.impl;

import com.publisher.model.Order;
import com.publisher.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    //private final Consumer<Integer> acceptOrderConsumer;
    private final StreamBridge streamBridge;

    @Override
    public void sendEmail(String email) {
        log.info("Sending email to {}",email);
        streamBridge.send("email", email);
        //acceptOrderConsumer.accept((int) id);
    }
}
