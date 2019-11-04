package com.tron.consul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-11-04
 */
@RestController
public class MyDataProviderController {

    @RequestMapping("/getData")
    public String getData() {
        return "data from consul service";
    }
}
