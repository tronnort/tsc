package com.tron.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


//自定义的方法使用spring的基础组件
//原理看ApplicationContextAwareProcessor
@Component
public class MyFirstAware implements ApplicationContextAware{
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("--------回调设置context-------");
        this.context = applicationContext;
    }
}
