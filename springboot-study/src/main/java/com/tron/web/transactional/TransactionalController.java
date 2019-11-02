package com.tron.web.transactional;

import com.tron.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TransactionalController {

    @Autowired
    TronTransactional tronTransactional;

    @RequestMapping("/aop")
    public String aop() {
        User user = new User();
        user.setId("5").setAge(29).setBalance(BigDecimal.valueOf(100)).setName("tron").setUsername("tron");
        tronTransactional.addUser(user);
        return "success";
    }
}
