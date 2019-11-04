package com.tron.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @auther tron
 * @create 2019-11-04
 */
@SpringBootApplication
@EnableFeignClients
public class MyFeignThree {
    public static void main(String[] args) {
        SpringApplication.run(MyFeignThree.class, args);
    }
}
