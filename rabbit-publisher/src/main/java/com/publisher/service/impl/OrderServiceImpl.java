package com.publisher.service.impl;

import com.publisher.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final StreamBridge streamBridge;

    @Override
    public Map<String, String> order(Long id) {
        streamBridge.send("order", id);
        log.info("Order completed with {}", id);
        return Collections.singletonMap("message", String.format("Order completed with %s", id));
    }
}
