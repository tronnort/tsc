package com.tron.configexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Tron tron() {
        return new Tron();
    }
}
