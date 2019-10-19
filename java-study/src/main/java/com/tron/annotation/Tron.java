package com.tron.annotation;

import java.lang.annotation.*;

// 类接口     包     方法    字段
@Target({ElementType.TYPE,ElementType.PACKAGE,ElementType.METHOD,ElementType.FIELD})
//保留到什么时候
@Retention(RetentionPolicy.RUNTIME)
//可以被继承
@Inherited
public @interface Tron {
    String value();
    int age() default 18;
}
