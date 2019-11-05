package com.tron.feign.service;

import com.tron.entity.CommonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient("feign-two")
public interface FeignService {

    @GetMapping("/getCommonDatas")
    List<CommonData> getCommonDatas();

    @GetMapping("/getCommonDataById")
    CommonData getCommonDataById(@RequestParam(value = "id") String id);

    @PostMapping("/updateCommonDataById")
    String updateCommonDataById(@RequestBody CommonData commonData);

}
