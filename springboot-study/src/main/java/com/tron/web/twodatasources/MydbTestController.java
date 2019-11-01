package com.tron.web.twodatasources;

import com.tron.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-11-01
 */
@RestController
public class MydbTestController {
    @Autowired
    private Mydb1Mapper mydb1Mapper;

    @Autowired
    private  Mydb2Mapper mydb2Mapper;


    @RequestMapping("/mydbTest")
    public Object mydbTest() {
        User db1user = mydb1Mapper.selectById(1);
        User db2user = mydb2Mapper.selectById(1);
        return db1user+"-------"+db2user;
    }
}
