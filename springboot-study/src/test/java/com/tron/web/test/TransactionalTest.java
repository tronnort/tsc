package com.tron.web.test;

import com.tron.web.entity.User;
import com.tron.web.transactional.TronTransactional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TransactionalTest extends MyTest {
    @Autowired
    TronTransactional tronTransactional;

    @Test
    public void testTransactional() {
        User user = new User();
        user.setId("5").setAge(29).setBalance(BigDecimal.valueOf(100)).setName("tron").setUsername("tron");
        tronTransactional.addUser(user);
    }
}
