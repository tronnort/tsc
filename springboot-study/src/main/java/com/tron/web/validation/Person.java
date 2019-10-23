package com.tron.web.validation;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */

@Data
public class Person {
    @NotBlank(message = "姓名不能为空",groups = AddGroup.class)
    private String name;
    @Email(message = "邮件地址不合法",groups = {AddGroup.class,UpdateGroup.class})
    private String email;
    @Min(message = "年龄不能小于1",value = 1,groups = {AddGroup.class,UpdateGroup.class})
    private Integer age;
}
