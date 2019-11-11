package com.tron.spring.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        /**
         *
         *判断容器中是否有什么bean
         *
         * */
        BeanDefinitionRegistry registry = context.getRegistry();
        boolean is = registry.containsBeanDefinition("myConfig");
        System.out.println(is);


        /**
         *
         * 获取环境变量
         *
         * */
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("user.name");
        System.out.println(property);

        //return true 时注入bean
        return true;
    }

    private void pringString(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            System.out.println("---Conditional---"+strings[i]);
        }
    }
}
