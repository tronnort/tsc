package com.tron.web.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;



@Mapper
@Component
public interface SchoolMapper extends BaseMapper<School>{

    @Select("select * from school where id =${id}")
    @ResultMap(value = "schoolMap")
     School myGetSchool(String id);

}
