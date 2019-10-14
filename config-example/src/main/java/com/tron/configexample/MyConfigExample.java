package com.tron.configexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyConfigExample {
    public static void main(String[] args) {
        SpringApplication.run(MyConfigExample.class, args);
    }
}
