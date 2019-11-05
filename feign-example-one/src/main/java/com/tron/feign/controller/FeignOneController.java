package com.tron.feign.controller;

import com.tron.entity.CommonData;
import com.tron.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/feignTest01")
    public Object feignTest01() {
        return feignService.getCommonDatas();
    }

    @RequestMapping("/feignTest02")
    public Object feignTest02(String id) {
        return feignService.getCommonDataById(id);
    }

    @RequestMapping("/feignTest03")
    public Object feignTest03(@RequestBody CommonData commonData) {
        return feignService.updateCommonDataById(commonData);
    }
}
