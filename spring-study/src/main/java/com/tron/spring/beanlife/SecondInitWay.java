package com.tron.spring.beanlife;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


//继承spring接口指定初始化和销毁调用方法
public class SecondInitWay implements InitializingBean,DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("SecondInitWay-----destroy-----");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("SecondInitWay-----init-----");
    }
}
