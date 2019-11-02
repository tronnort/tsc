package com.tron.web.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tron.web.mybatis.School;
import com.tron.web.mybatis.SchoolService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SchoolServiceTest extends MyTest {

    @Autowired
    SchoolService schoolService;

    @Test
    public void addSchoolTest() {
        schoolService.addSchool(new School().setId("2").setName("北大").setAddress("北京"));
    }

    @Test
    public void getSchoolInfo() {
        School school = schoolService.myGetSchool("1");
        System.out.println(school);
    }

    @Test
    public void allWrapperTest() {
        QueryWrapper<School> wrapper = new QueryWrapper<>();

        HashMap<String, Object> map = new HashMap<>();

        /**
         *
         *   wrapper.allEq(map);
         *
         * */
//        map.put("id", "1");
//        map.put("name", "清华");      SELECT id,address,name FROM school WHERE (name = ? AND id = ?)

//        map.put("id","1");
//        map.put("name", null);     SELECT id,address,name FROM school WHERE (name IS NULL AND id = ?)

//        wrapper.allEq(map);

        /**
         *
         * wrapper.allEq(map, false);
         *
         * */
//        map.put("id", 1);
//        map.put("name", null);  SELECT id,address,name FROM school WHERE (id = ?)
//        wrapper.allEq(map, false);

        /**
         *
         * wrapper.ne("id", 1)   不等于
         *
         * */
//        wrapper.ne("id", 1).eq("id",2);   SELECT id,address,name FROM school WHERE (id <> ? AND id = ?)
//        wrapper.ne(false, "id", null);   SELECT id,address,name FROM school   （排除空条件）

        List<School> schools = schoolService.allWrapperTest(wrapper);
        System.out.println(schools);
    }
}
