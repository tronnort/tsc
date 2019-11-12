package com.tron.spring.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class MySecondAware implements EnvironmentAware {
    private  Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("运行环境："+environment.getProperty("os.name"));
        System.out.println("JDK版本："+environment.getProperty("java.version"));
        this.environment = environment;
    }
}
