package com.tron.web.ErrorHandler;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("/")
    public Object test(String str) {
        Assert.notNull(str,"需要传入一个非空字符");   //简单类型的错误
        if (true){
            throw new MyException();
        }
        return "null";
    }
}
