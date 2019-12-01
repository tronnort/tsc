package com.tron.web.test;

import com.tron.web.entity.User;
import com.tron.web.jdbctemplate.JdbcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-12-01
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcTemplateTest {

    @Autowired
    private JdbcService jdbcService;

    @Test
    public void test01() {
        User user = jdbcService.getUser(1 + "");
        System.out.println(user);
    }

    @Test
    public void test02() {
        List<User> allUser = jdbcService.getAllUser();
        System.out.println(allUser);
    }

    @Test
    public void test03() {
        List users = jdbcService.getUserByNameAndAge("张三", 18);
        System.out.println(users);
    }

    @Test
    public void test04() {
        List<Map<String, Object>> maps = jdbcService.tron01();
        for (Map map : maps) {
            map.forEach((k,v)->{
                System.out.println(k+"---"+v);
            });
            System.out.println("------------------------------");
        }
    }

    @Test
    public void test05() {
        System.out.println(jdbcService.tron02());
    }

    @Test
    public void test06() {
        System.out.println(jdbcService.tron03());
    }

    @Test
    public void test07() {
        System.out.println(jdbcService.tron04());
    }

    @Test
    public void test08() {
        System.out.println(jdbcService.tron05());
    }

    @Test
    public void test09() {
        System.out.println(jdbcService.tron06());
    }
}
