package com.tron.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(Integer id,String name) {
        userDao.add(id,name);
        Integer i =1/0;
    }
}
