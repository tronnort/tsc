package com.tron.web.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description
 * @auther tron
 * @create 2019-11-15
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase,String>{

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        System.out.println("获取注解的值初始化方法执行");
        //获取注解中预设的值
        System.out.println(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println(value);
        if (value == null) {
            return true;
        }
        //获取方法传参value,执行校验逻辑,返回false时,返回message中的错误信息
        return value.length()>1;
    }
}
