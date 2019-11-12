package com.tron.spring.beanlife;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


//通过java注解指定初始化和销毁调用方法
public class FirstInitWay {

    @PostConstruct
    public void init() {
        System.out.println("FirstInitWay-----init-----");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("FirstInitWay-----destroy-----");
    }
}
