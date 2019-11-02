package com.tron.web.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface SchoolClassMapper extends BaseMapper<SchoolClass>{
    @Select("select * from school_class where school_id = ${schoolId}")
    List<SchoolClass> getSchoolClassBySchoolId(String schoolId);

    @Select("select * from school_class where id = ${id}")
    @ResultMap(value = "schoolClassMap")
    SchoolClass myGetSchoolClass(String id);
}
