package com.tron.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestReadConfig {

    @Autowired
    private MyEnvironment myEnvironment;

    @RequestMapping("/readConfig")
    public void readConfig() {
        System.out.println(myEnvironment);
    }
}
