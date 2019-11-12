package com.tron.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Integer id,String name) {
        String sql = "INSERT INTO a (id,name) VALUES(?,?)";
        jdbcTemplate.update(sql, id, name);
    }
}
