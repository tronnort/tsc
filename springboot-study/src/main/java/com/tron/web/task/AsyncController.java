package com.tron.web.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;


    @GetMapping("/testAsync")
    public Object testAsync() throws InterruptedException {
        asyncService.getStr();
        return new FormDataTest("controller 方法立即返回");
    }
}
