package com.tron.feign.controller;

import com.tron.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-11-04
 */
@RestController
public class TestController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/testGetData")
    public String testGetData() {
        return feignService.getData();
    }
}
