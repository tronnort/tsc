package com.tron.web.test;

import com.tron.web.mybatis.entity.TestData;
import com.tron.web.mybatis.mapper.TestMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBatisTest extends MyTest {

    @Autowired
    TestMapper testMapper;

    @Test
    public void myBatisTest() {
        TestData testData = new TestData();
        testData.setId("000111");
        testMapper.insert(testData);
    }

}
