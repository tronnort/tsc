package com.tron.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-27
 */
@Component
public class GetEnvTest {
    @Autowired
    StandardEnvironment standardEnvironment;

    public StandardEnvironment getEnv() {
        return standardEnvironment;
    }
}
