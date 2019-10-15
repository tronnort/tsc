package com.tron.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("feign-one")
@Component
public interface FeignService {

    @RequestMapping("/getName")
    String getName();

}
