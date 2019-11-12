package com.tron.spring.injectbean;

import org.springframework.stereotype.Component;

//通过ConfigForInjectBean类@ComponentScan(basePackages = "com.tron.spring.injectbean")包扫描装配bean
//标注有 @Repository @Service @Controller...等注解的类也能被包扫描装配进容器
@Component
public class ThirdWay {
}
