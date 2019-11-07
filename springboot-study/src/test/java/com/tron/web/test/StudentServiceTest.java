package com.tron.web.test;

import com.tron.web.mybatis.School;
import com.tron.web.mybatis.Student;
import com.tron.web.mybatis.StudentMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceTest extends MyTest {
    @Autowired
    StudentMapper studentMapper;


}
