package com.tron.feign.fallback;


import com.tron.entity.CommonData;
import com.tron.feign.service.FeignService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyFallBack implements FeignService{


    @Override
    public String getName() {
        return "FeignTwo服务异常了";
    }

    @Override
    public List<CommonData> getCommonDatas() {
        return null;
    }

    @Override
    public CommonData getCommonDataById(String id) {
        return null;
    }

    @Override
    public String updateCommonDataById(CommonData commonData) {
        return null;
    }
}
