package com.tron.web.mybatis;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class SchoolClass {
    private String id;
    private String schoolId;
    private String name;
    private String classNo;
    @TableField(exist = false)
    private List<Student> student;
}
