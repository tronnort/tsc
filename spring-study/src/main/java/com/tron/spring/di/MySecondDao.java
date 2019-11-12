package com.tron.spring.di;

import org.springframework.stereotype.Repository;

@Repository
public class MySecondDao {
    public String getData() {
        return "I am from MySecondDao";
    }
}
