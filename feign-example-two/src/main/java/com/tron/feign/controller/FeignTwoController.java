package com.tron.feign.controller;

import com.tron.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignTwoController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/getName")
    public String getName() throws Exception{
        Thread.sleep(2000);
        return "I am from FeignTwo";
    }

    @RequestMapping("/getNameFromFeignOne")
    public String getNameFromFeignOne(){
        return feignService.getName();
    }
}
