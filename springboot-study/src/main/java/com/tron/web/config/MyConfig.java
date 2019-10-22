package com.tron.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@MapperScan("com.tron.web.mapper")
public class MyConfig {

}
