package com.tron.web.transactional;

import com.tron.web.entity.User;
import com.tron.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TronTransactional {
    @Autowired
    private IUserService userService;

    @Transactional
    public Object addUser(User user) {
        userService.save(user);
//        int e = 1/0;
        return "success";
    }
}
