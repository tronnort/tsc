package com.tron.spring.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Strat {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.addUser(113,"tron");
    }
}
