package com.tron.feign.service.impl;

import com.tron.entity.CommonData;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @auther tron
 * @create 2019-11-05
 */
@Service
public class CommonDataServiceImpl {

    public List<CommonData> getCommonDatas() {
        return Arrays.asList(
                new CommonData().setString("1").setInteger(1),
                new CommonData().setString("2").setInteger(2),
                new CommonData().setString("3").setInteger(3)
        );
    }


    public CommonData getCommonDataById(String id) {
        CommonData commonData = new CommonData().setString(id).setInteger(200);
        return commonData;
    }

    public String updateCommonDataById(CommonData commonData) {
        return commonData.getString();
    }
}
