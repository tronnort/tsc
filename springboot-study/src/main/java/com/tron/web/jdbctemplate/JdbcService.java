package com.tron.web.jdbctemplate;

import com.tron.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
     * 新增数据或更新数据
     *
     * @param id
     * @param username
     * @param name
     * @param age
     * @param balance
     * @return
     */
    public String tron01(String id, String username, String name, Integer age, BigDecimal balance) {
        //测试中发现主键重复并不会报错，而是执行更新方法。
        int insert = jdbcTemplate.update("INSERT INTO user(id,username,name,age,balance) VALUES (?,?,?,?,?)", id, username, name, age, balance);
        return id;
    }


    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    public Boolean tron02(String id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
        Assert.isTrue(tron03(id) == 0, "删除失败");
        return true;
    }

    /**
     * 删除数据的校验条件
     *
     * @param id
     * @return
     */
    public Integer tron03(String id) {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM user WHERE id = ?", Integer.class, id);
        return count;
    }

    /**
     * 批量新增和修改方法
     *
     * @param args
     * @return
     */
    public Integer tron04(List<Object[]> args) {
        int[] ints = jdbcTemplate.batchUpdate("INSERT INTO user(id,username,name,age,balance) VALUES (?,?,?,?,?)", args);
        return ints.length;
    }

    /**
     * 批量删除
     *
     * @param args
     * @return
     */
    public Integer tron05(List<String> args) {
        int[] ints = jdbcTemplate.batchUpdate("DELETE FROM user WHERE id = ?", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                //前面的1代表sql的第一个问号
                ps.setString(1, args.get(i));
            }

            @Override
            public int getBatchSize() {
                //判断是否大于100条
                return args.size() > 100 ? 100 : args.size();
            }
        });
        return ints.length;
    }

    /**
     * 查询单个对象
     *
     * @param id
     * @return
     */
    public User tron06(String id) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = ?", new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    /**
     * 查询单个对象，适用于多表返回的对象，没有实体对能映射所有字段时。
     *
     * @param id
     * @return
     */
    public Map<String, Object> tron07(String id) {
        Map<String, Object> map = jdbcTemplate.queryForMap("SELECT u.id AS userId,u.name AS userName FROM user u WHERE id = ?", id);
        return map;
    }

    /**
     * 列表查询
     *
     * @return
     */
    public List<User> tron08() {
        List<User> list = jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    /**
     * 列表查询 适用于多表返回的对象，没有实体对能映射所有字段时。
     *
     * @return
     */
    public List<Map<String, Object>> tron09(String id) {
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("SELECT * FROM user WHERE id > ?", id);
        return mapList;
    }


    /**
     * 分页实现
     *  pageNum  页码 从1开始
     *  pageRow  每页显示条数 默认50  可优化到配置文件
     * @return
     */
    public List<User> tron10(Integer pageNum, Integer pageRow, String id) {
        //这里是需要修改的地方，根据业务。
        String baseSql = "SELECT * FROM user WHERE id > ?";
        int i = baseSql.indexOf("from");
        int j = baseSql.indexOf("FROM");
        String substring = baseSql.substring(i == -1 ? j : i, baseSql.length());
        String countSql = new StringBuilder("SELECT count(*) ").append(substring).toString();
        //这里是需要修改的地方，根据不同业务，传的参数也不同，一个问号占位符代表一个参数。
        Integer total = jdbcTemplate.queryForObject(countSql, Integer.class, id);
        //这里是需要修改的地方，默认分页50条。
        pageRow = pageRow == 0 ? 50 : pageRow;
        Integer pages = total % pageRow == 0 ? total / pageRow : total / pageRow + 1;
        String limitSql = new StringBuilder(baseSql).append(" LIMIT ").append(" ? ").append(",").append(" ? ").toString();
        //这里是需要修改的地方，根据不同业务，传的参数也不同，一个问号占位符代表一个参数。
        List<User> query = jdbcTemplate.query(limitSql, new BeanPropertyRowMapper<>(User.class), id, (pageNum - 1) * pageRow, pageRow);
        System.out.println("总条数：" + total + "---" + "当前页：" + pageNum + "---" + "当前显示条数：" + query.size() + "---" + "总页数：" + pages);
        return query;
    }


}
