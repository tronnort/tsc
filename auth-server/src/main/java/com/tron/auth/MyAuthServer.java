package com.tron.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description
 * @auther tron
 * @create 2019-10-09
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class MyAuthServer {
    public static void main(String[] args) {
        SpringApplication.run(MyAuthServer.class, args);
    }
}
