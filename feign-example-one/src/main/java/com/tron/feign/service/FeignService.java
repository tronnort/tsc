package com.tron.feign.service;

import com.tron.entity.CommonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "feign-two")
public interface FeignService {

    @RequestMapping("/getCommonDatas")
    public abstract List<CommonData> getCommonDatas();

    @GetMapping("/getCommonDataById")
    public abstract CommonData getCommonDataById(@RequestParam(value = "id") String id);

    @PostMapping("/updateCommonDataById")
    public abstract String updateCommonDataById(@RequestBody CommonData commonData);

}
