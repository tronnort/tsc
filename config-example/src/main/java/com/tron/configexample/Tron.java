package com.tron.configexample;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("tron")
public class Tron {
    private String name;
    private String phone;
    private String email;
}
