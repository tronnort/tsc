package com.tron.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients
@EnableHystrixDashboard
public class MyFeignOne {
    public static void main(String[] args) {
        SpringApplication.run(MyFeignOne.class, args);
    }
}
