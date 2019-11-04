package com.tron.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCheckHealthController {

    @RequestMapping("/health")
    public String health() {
        return "success";
    }
}
