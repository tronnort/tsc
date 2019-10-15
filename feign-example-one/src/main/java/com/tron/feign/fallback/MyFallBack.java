package com.tron.feign.fallback;


import com.tron.feign.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class MyFallBack implements FeignService{


    @Override
    public String getName() {
        return "FeignTwo服务异常了";
    }
}
