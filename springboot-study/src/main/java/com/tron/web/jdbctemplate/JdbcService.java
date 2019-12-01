package com.tron.web.jdbctemplate;

import com.tron.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-12-01
 */
@Service
public class JdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过id 单条件查询
     * @param id
     * @return
     */
    public User getUser(String id) {
        String sql = "select * from user where id = ?";
        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return user;
    }

    public List getUserByNameAndAge(String name, Integer age) {
        String sql = "select * from user where name like ? and age > ?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, name, age);
        return list;
    }

    /**
     * 查询列表
     * @return
     */
    public List<User> getAllUser() {
        String sql = "select * from user ";
        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        return users;
    }

    public List<Map<String, Object>> tron01() {
        ColumnMapRowMapper mapRowMapper = new ColumnMapRowMapper();
        List<Map<String, Object>> maps = jdbcTemplate.query("select * from user ", mapRowMapper);
        return maps;
    }


    public Object tron02() {
        String integer = jdbcTemplate.queryForObject("select id  from user where id = 1", String.class);
        return integer;
    }

    public Map tron03() {
        Map<String, Object> forMap = jdbcTemplate.queryForMap("select * from user where id =1");
        return forMap;
    }

    public User tron04() {
        User user = jdbcTemplate.queryForObject("select * from user where id =1", new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public Object tron05() {
        return jdbcTemplate.queryForList("select id from user", Integer.class);
    }

    public Object tron06() {
        return jdbcTemplate.queryForList("select * from user");
    }



}
