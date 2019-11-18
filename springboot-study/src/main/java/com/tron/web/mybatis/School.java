package com.tron.web.mybatis;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@TableName("school")
public class School {
    private String id;
    private String pid;
    private String name;
    private String address;
    @TableField(exist = false)
    private List<SchoolClass> schoolClass;
    @TableField(exist = false)
    private List<School> schools;
}
