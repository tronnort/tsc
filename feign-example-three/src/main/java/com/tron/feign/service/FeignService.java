package com.tron.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "consul-server")
@Service
public interface FeignService {

    @RequestMapping("/getData")
    String getData();
}
