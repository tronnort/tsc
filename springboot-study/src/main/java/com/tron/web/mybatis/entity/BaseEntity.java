package com.tron.web.mybatis.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable{
    @TableField(value = "create_by", fill = FieldFill.INSERT) // 新增执行
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")      //fastJson序列化   需要在配置类中添加fastJson配置
    private Date createTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
    private String updateBy;

    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
//    @JSONField(format = "yyyy年MM月dd日 HH:mm:ss")
    @JSONField(serialize = false)
    private Date updateTime;

}
