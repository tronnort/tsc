package com.tron.feign.service;

import com.tron.entity.CommonData;
import com.tron.feign.fallback.MyFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "feign-two",fallback = MyFallBack.class)
@Component
public interface FeignService {

    @RequestMapping("/getName")
    String getName();

    @RequestMapping(name = "/getCommonDatas",method = RequestMethod.GET)
    List<CommonData> getCommonDatas();


    @RequestMapping(name = "/getCommonDataById",method = RequestMethod.GET)
    CommonData getCommonDataById(@RequestParam(value = "id") String id);

    @RequestMapping(name = "/updateCommonDataById",method = RequestMethod.POST)
    String updateCommonDataById(@RequestBody CommonData commonData);
}
