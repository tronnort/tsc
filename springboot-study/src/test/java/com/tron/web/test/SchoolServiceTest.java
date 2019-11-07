package com.tron.web.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tron.web.mybatis.School;
import com.tron.web.mybatis.SchoolMapper;
import com.tron.web.mybatis.SchoolService;
import com.tron.web.mybatis.SchoolVo;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SchoolServiceTest extends MyTest {

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolMapper schoolMapper;

    @Test
    public void testGetSchoolTree() {
        List<School> schoolTree = schoolMapper.getSchoolTree("0");
        System.out.println(schoolTree);
    }

    @Test
    public void testGetSchoolClassTree() {
        List<School> schoolClassTree = schoolMapper.getSchoolClassTree("4");
        System.out.println(schoolClassTree);
    }

    @Test
    public void testCopy() {
        School school = new School();
        school.setId("1").setName("牛津");

        SchoolVo schoolVo = new SchoolVo();

        BeanUtils.copyProperties(school, schoolVo);

        System.out.println(schoolVo);

    }


}
