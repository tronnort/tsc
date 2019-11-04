package com.tron.consul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-11-04
 */

@RestController
public class MyCheckHealthController {

    @RequestMapping("/health")
    public String health() {
        return "success";
    }
}
