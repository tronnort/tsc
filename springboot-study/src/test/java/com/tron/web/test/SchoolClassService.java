package com.tron.web.test;


import com.tron.web.mybatis.SchoolClass;
import com.tron.web.mybatis.SchoolClassMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolClassService extends MyTest {
    @Autowired
    SchoolClassMapper schoolClassMapper;

    @Test
    public void getSchoolClassBySchoolId() {
        List<SchoolClass> result = schoolClassMapper.getSchoolClassBySchoolId("1");
        System.out.println(result);
    }

    @Test
    public void myGetSchoolClass() {
        SchoolClass schoolClass = schoolClassMapper.myGetSchoolClass("1");
        System.out.println(schoolClass);
    }
}
