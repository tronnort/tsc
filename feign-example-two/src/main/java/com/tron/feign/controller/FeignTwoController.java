package com.tron.feign.controller;

import com.tron.entity.CommonData;
import com.tron.feign.service.FeignService;
import com.tron.feign.service.impl.CommonDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeignTwoController {

    @Autowired
    private FeignService feignService;

    @Autowired
    private CommonDataServiceImpl commonDataService;

    @RequestMapping("/getName")
    public String getName() throws Exception{
        Thread.sleep(2000);
        return "I am from FeignTwo";
    }

    @RequestMapping("/getNameFromFeignOne")
    public String getNameFromFeignOne(){
        return feignService.getName();
    }

    @RequestMapping("/getCommonDatas")
    public List<CommonData> getCommonDatas() {
        return commonDataService.getCommonDatas();
    }


    @RequestMapping(name = "/getCommonDataById",method = RequestMethod.GET)
    public CommonData getCommonDataById(String id) {
        return commonDataService.getCommonDataById(id);
    }

    @RequestMapping(name = "/updateCommonDataById",method = RequestMethod.POST)
    public String updateCommonDataById(@RequestBody CommonData commonData) {
        return commonDataService.updateCommonDataById(commonData);
    }
}
