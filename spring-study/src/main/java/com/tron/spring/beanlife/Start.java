package com.tron.spring.beanlife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigForBeanLife.class);
        context.getBean(FirstInitWay.class);
        context.close();
    }
}
