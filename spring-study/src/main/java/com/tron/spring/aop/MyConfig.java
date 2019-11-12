package com.tron.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
/**
 * @Import(AspectJAutoProxyRegistrar.class)
 *  class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar
 *
 *
 *
 * */
@ComponentScan(basePackages = {"com.tron.spring.aop"})
public class MyConfig {
}
