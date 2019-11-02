package com.tron.web.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    public School myGetSchool(String id) {
        School school = schoolMapper.myGetSchool(id);
        return school;
    }

    public String addSchool(School school) {
        int insert = schoolMapper.insert(school);
        Assert.isTrue(insert==1,"添加学校失败");
        return school.getId();
    }


    /**
     *
     * wrapper 完整语法测试
     *
     * */
    public List<School> allWrapperTest(Wrapper<School> wrapper) {
        List<School> schools = schoolMapper.selectList(wrapper);
        return schools;
    }
}
