package com.tron.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-27
 */
@Configuration
public class Config {

//    @Bean
//    @Profile("dev")
//    public DevProfile devProfile() {
//        return new DevProfile();
//    }

    @Bean
    public DevProfile devProfile1() {
        return new DevProfile();
    }
}
