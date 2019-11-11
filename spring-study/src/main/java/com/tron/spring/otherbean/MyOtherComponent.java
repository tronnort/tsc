package com.tron.spring.otherbean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyOtherComponent {

    @PostConstruct
    public void init() {
        System.out.println("--------------MyOtherComponent初始化方法------------");
    }

    @Deprecated
    public void dest() {
        System.out.println("--------------MyOtherComponent销毁方法------------");
    }
}
