package com.tron.spring.beanlife;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.tron.spring.beanlife"})
@Import({FirstInitWay.class,SecondInitWay.class})
public class ConfigForBeanLife {

}
