package com.tron.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-27
 */
public class Start {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        applicationContext.getEnvironment().setActiveProfiles("dev");

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

    }
}
