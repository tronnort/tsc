package com.tron.web.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface SchoolMapper extends BaseMapper<School>{

//    @Select("select * from school where id =${id}")
//    @ResultMap(value = "schoolMap")
//     School myGetSchool(String id);

    List<School> getSchoolTree(String pid);

    List<School> getSchoolClassTree(String id);

}
