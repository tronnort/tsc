package com.tron.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TronAop {

    @Pointcut("execution(* com.tron.spring.aop.*.*(..))")
    public void poincut() {

    }

    @Before("poincut()")
    public void before() {
        System.out.println("TronAop-----start");
    }
}
