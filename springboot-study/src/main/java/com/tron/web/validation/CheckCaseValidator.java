package com.tron.web.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Description
 * @auther tron
 * @create 2019-11-15
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase,Object>{


    @Override
    public void initialize(CheckCase constraintAnnotation) {
        System.out.println("获取注解的值初始化方法执行");
        //获取注解中预设的值
        System.out.println(constraintAnnotation);

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        System.out.println(value);
        if (value == null) {
            return false;
        }
        Supplier<Map<String,String>> supplier = (Supplier) value;
        Map<String, String> map = supplier.get();
        context.buildConstraintViolationWithTemplate(map.get("msg")).addConstraintViolation();
        return "true".equals(map.get("result"));
    }
}
