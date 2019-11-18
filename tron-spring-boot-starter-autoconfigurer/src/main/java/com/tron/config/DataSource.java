package com.tron.config;

import lombok.Data;

@Data
public class DataSource {
    private String url;
    private String userName;
    private String passWord;
    private String driverClassName;
}
