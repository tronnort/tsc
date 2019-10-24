package com.tron.web.parameters;

import lombok.Data;

@Data
public class Person {
    private String name;
    private Integer age;
    private boolean marry;
    private String [] friends;
}
