package com.tron.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description
 * @auther tron
 * @create 2019-10-09
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class MyZuulServer {
    public static void main(String[] args) {
        SpringApplication.run(MyZuulServer.class, args);
    }
}
