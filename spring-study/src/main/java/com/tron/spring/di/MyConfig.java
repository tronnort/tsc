package com.tron.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"com.tron.spring.di"})
public class MyConfig {
//    注意一下两个注解的使用
//    @Qualifier
//    @Primary
}
