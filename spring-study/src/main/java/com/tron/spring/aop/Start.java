package com.tron.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        TronController tronController = context.getBean(TronController.class);
        tronController.print();
    }
}
