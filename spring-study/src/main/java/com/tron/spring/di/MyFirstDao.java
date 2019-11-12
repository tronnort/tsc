package com.tron.spring.di;

import org.springframework.stereotype.Repository;

@Repository
public class MyFirstDao {
    public String getData() {
        return "I am from MyFirstDao";
    }
}
