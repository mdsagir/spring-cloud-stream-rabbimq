package com.publisher.controller;

import com.publisher.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("notification")
public class EmailController {

    private final EmailService orderService;

    @GetMapping("/{email}")
    public Map<String, String> order(@PathVariable String email) {
        orderService.sendEmail(email);
        return Collections.singletonMap("message", String.format("Email: %s Sends  successfully",email));
    }
}
