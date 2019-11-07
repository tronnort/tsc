package com.tron.web.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper extends BaseMapper<Student>{

//    @Select("select * from student where id = ${schoolClassId}")
//    List<Student> getStudentBySchoolClassId(String schoolClassId);
//
//    @Select("select * from school where id = ${id}")
//    @ResultMap("schoolTree")
//    School findOne(String id);
//
//    @Select("select * from school_class where school_id = ${id}")
//    @ResultMap("schoolClassTree")
//    List<SchoolClass> findSchoolClassesBySchoolId(String id);
//
//    @Select("select * from student where class_id = ${id}")
//    List<Student> findStudentsBySchoolClassId(String id);
//
//    @Select("select * from school_class")
//    @ResultMap("schoolClassTree")
//    List<SchoolClass> findTwos();

}
