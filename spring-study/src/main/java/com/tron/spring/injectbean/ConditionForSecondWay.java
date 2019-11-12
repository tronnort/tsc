package com.tron.spring.injectbean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;


public class ConditionForSecondWay implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

//        判断容器中是否有什么bean
        BeanDefinitionRegistry registry = context.getRegistry();
        boolean is = registry.containsBeanDefinition("myConfig");


//        获取环境变量
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("当前系统环境："+property);

//        return true 时注入bean
        return true;
    }
}
