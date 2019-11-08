package com.tron.web.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tron.web.mybatis.School;
import com.tron.web.mybatis.SchoolMapper;
import com.tron.web.mybatis.SchoolService;
import com.tron.web.mybatis.SchoolVo;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
        School school1 = new School();
        school1.setId("2").setName("清华");

        ArrayList<School> schools = new ArrayList<>();
        schools.add(school);
        schools.add(school1);

        SchoolVo schoolVo = new SchoolVo();

        ArrayList<SchoolVo> schoolVos = new ArrayList<>();

        for (int i = 0; i < schools.size(); i++) {
            BeanUtils.copyProperties(schools.get(i),schoolVo);
            schoolVos.add(schoolVo);
        }

        System.out.println(schoolVos);

        System.out.println(schoolVo);

    }


}
