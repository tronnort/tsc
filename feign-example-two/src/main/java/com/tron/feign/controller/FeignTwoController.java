package com.tron.feign.controller;

import com.tron.entity.CommonData;
import com.tron.feign.service.impl.CommonDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeignTwoController {

    @Autowired
    private CommonDataServiceImpl commonDataService;


    @GetMapping("/getCommonDatas")
    public List<CommonData> getCommonDatas() throws InterruptedException {
        Thread.sleep(5000);
        return commonDataService.getCommonDatas();
    }


    @GetMapping("/getCommonDataById")
    public CommonData getCommonDataById(String id) throws InterruptedException {
        Thread.sleep(5000);
        return commonDataService.getCommonDataById(id);
    }

    @PostMapping("/updateCommonDataById")
    public String updateCommonDataById(@RequestBody CommonData commonData) {
        return commonDataService.updateCommonDataById(commonData);
    }
}
