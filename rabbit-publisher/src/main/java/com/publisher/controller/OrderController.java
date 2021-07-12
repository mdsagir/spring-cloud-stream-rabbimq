package com.publisher.controller;

import com.publisher.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("order/{id}")
    public Map<String,String> order(@PathVariable  Long id) {
        return orderService.order(id);
    }

}
