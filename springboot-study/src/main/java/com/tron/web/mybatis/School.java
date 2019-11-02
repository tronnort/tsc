package com.tron.web.mybatis;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class School {
    private String id;
    private String name;
    private String address;
    @TableField(exist = false)
    private List<SchoolClass> schoolClass;
}
