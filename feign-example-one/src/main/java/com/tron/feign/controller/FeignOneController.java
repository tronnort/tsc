package com.tron.feign.controller;

import com.tron.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignOneController {

    @Autowired
    private FeignService feignService;

    @RequestMapping("/getName")
    public String getName() {
        return "I am from FeignOne";
    }

    @RequestMapping("/getNameFromFeignTwo")
    public String getNameFromFeignTwo(){
        return feignService.getName();
    }
}
