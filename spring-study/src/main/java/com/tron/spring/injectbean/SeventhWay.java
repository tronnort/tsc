package com.tron.spring.injectbean;

import org.springframework.beans.factory.FactoryBean;


//通过ConfigForInjectBean类@Bean注解向容器中装配JavaBean
public class SeventhWay implements FactoryBean<BeanForSeventhWay>{
    @Override
    public BeanForSeventhWay getObject() throws Exception {
        return new BeanForSeventhWay();
    }

    @Override
    public Class<?> getObjectType() {
        return BeanForSeventhWay.class;
    }

    @Override
    public boolean isSingleton() {
        //true在容器中只保存一份
        return true;
    }
}
