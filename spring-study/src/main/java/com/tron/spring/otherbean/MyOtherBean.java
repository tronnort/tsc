package com.tron.spring.otherbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class MyOtherBean implements InitializingBean,DisposableBean{

    @Override
    public void destroy() throws Exception {
        System.out.println("--------------MyOtherBean销毁方法------------");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("--------------MyOtherBean初始化方法------------");
    }
}
