package com.tron.spring.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-27
 */

@Component
@Profile("dev")
public class DevProfile {

    public String a = "a";
    protected String b = "b";
    private String c = "c";

}
