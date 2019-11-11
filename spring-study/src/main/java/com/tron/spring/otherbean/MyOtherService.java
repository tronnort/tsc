package com.tron.spring.otherbean;

import com.tron.spring.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyOtherService {

    @Autowired
    MyUtil myUtil;

    public void test() {
        myUtil.test();
        MyUtil.staticTest();
    }
}
