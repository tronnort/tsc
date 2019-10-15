package com.tron.feign.service;

import com.tron.feign.fallback.MyFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "feign-two",fallback = MyFallBack.class)
@Component
public interface FeignService {

    @RequestMapping("/getName")
    String getName();
}
