package com.tron.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {

    @Autowired
    DataSource dataSource;


    @Test
    public void testDataSource() {
        System.out.println(dataSource.getClass().getName());
    }

}
