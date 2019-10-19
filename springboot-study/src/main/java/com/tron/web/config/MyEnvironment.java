package com.tron.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
@ConfigurationProperties( prefix = "mydata")
@Data
public class MyEnvironment {
    public String url;
    public Integer id;
    public ArrayList list;
    public HashMap<String,String> map;
}
