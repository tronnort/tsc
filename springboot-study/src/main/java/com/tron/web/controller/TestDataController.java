package com.tron.web.controller;

import com.tron.web.mybatis.entity.TestData;
import com.tron.web.mybatis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDataController {

    @Autowired
    TestMapper testMapper;

    @GetMapping("/addTestData/{id}")
    public TestData add(@PathVariable String id) {
        TestData testData = new TestData();
        testMapper.insert(testData);
        return testData;
    }
}
