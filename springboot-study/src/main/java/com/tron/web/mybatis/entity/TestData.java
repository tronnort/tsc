package com.tron.web.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test")
public class TestData extends BaseEntity {
    //主键自动生成uuid
    @TableId(type = IdType.UUID)
    private String id;
}
