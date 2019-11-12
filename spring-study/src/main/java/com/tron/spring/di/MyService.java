package com.tron.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private MySecondDao mySecondDao;

    @Autowired
    MyFirstDao myFirstDao;

    public void print01() {
        System.out.println(myFirstDao.getData());
    }

    public void print02() {
        System.out.println(mySecondDao.getData());
    }

    public MySecondDao getMySecondDao() {
        return mySecondDao;
    }

    @Autowired
    public void setMySecondDao(MySecondDao mySecondDao) {
        this.mySecondDao = mySecondDao;
    }
}
