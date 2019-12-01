package com.tron.web.test;

import com.tron.web.entity.User;
import com.tron.web.jdbctemplate.JdbcService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
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
        String id = jdbcService.tron01("001", "tron", "创", 19, BigDecimal.valueOf(10.0));
        System.out.println(id);
    }

    @Test
    public void test02() {
        Boolean b = jdbcService.tron02("001");
        System.out.println(b);
    }

    @Test
    public void test03() {
        Integer conut = jdbcService.tron03("001");
        System.out.println(conut);
    }

    @Test
    public void test04() {
        Integer length = jdbcService.tron04(Arrays.asList(
                new Object[]{"002", "lucy", "露丝o", 29, BigDecimal.valueOf(200)},
                new Object[]{"003", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"004", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"005", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"006", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"007", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"008", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"009", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"010", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"011", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"012", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"013", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"014", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"015", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"016", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"017", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"018", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"019", "jack", "杰克o", 26, BigDecimal.valueOf(200)},
                new Object[]{"020", "jack", "杰克o", 26, BigDecimal.valueOf(200)}
                )
        );
        System.out.println(length);
    }

    @Test
    public void test05() {
        Integer length = jdbcService.tron05(Arrays.asList("002", "003","004","005","006","007","008","009","010","011","012","013","014","015","016","017","018","019","020","021"));
        System.out.println(length);
    }

    @Test
    public void test06() {
        User user = jdbcService.tron06("1");
        System.out.println(user);
    }

    @Test
    public void test07() {
        Map<String, Object> map = jdbcService.tron07("3");
        System.out.println(map);
    }

    @Test
    public void test08() {
        List<User> users = jdbcService.tron08();
        System.out.println(users);
    }

    @Test
    public void test09() {
        List<Map<String, Object>> maps = jdbcService.tron09("1");
        System.out.println(maps);
    }

    @Test
    public void test10() {
        List<User> users = jdbcService.tron10(6,5,"002");
        System.out.println(users.size());
        System.out.println(users);
    }
}
