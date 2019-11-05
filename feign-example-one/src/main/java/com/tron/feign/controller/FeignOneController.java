package com.tron.feign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tron.controller.BaseController;
import com.tron.entity.CommonData;
import com.tron.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.tron.myenum.MyEnum.BUSY;
import static com.tron.myenum.MyEnum.SUCCESS;


@RestController
public class FeignOneController extends BaseController{

    @Autowired
    private FeignService feignService;


    @GetMapping("/feignTest01")
    @HystrixCommand(fallbackMethod = "feignTest01FallBack")
    public  FinalResult<List<CommonData>> feignTest01() {
        return buildFinalResult(feignService.getCommonDatas(), SUCCESS);
    }


    public  FinalResult<List<CommonData>> feignTest01FallBack() {
        return buildFinalResult(null, BUSY);
    }



    @GetMapping("/feignTest02")
    @HystrixCommand(fallbackMethod = "feignTest02FallBack")
    public FinalResult<CommonData> feignTest02(String id) {
        return buildFinalResult(feignService.getCommonDataById(id), SUCCESS);
    }

    public  FinalResult<CommonData> feignTest02FallBack(String id) {
        return buildFinalResult(null, BUSY);
    }

    @PostMapping("/feignTest03")
    public FinalResult<String> feignTest03(@RequestBody CommonData commonData) {
        return buildFinalResult(feignService.updateCommonDataById(commonData),SUCCESS);
    }

}
