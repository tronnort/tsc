package com.tron.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyGatewayConfig {

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }
}
