package com.tron.web.aop;


import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class TronAop {

    @Pointcut("execution(* com.tron.web.transactional.TransactionalController.*(..))")
    public void pointCut(){};

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName());
//        }
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);   //  请求映射路径
        Object[] args = joinPoint.getArgs();
        System.out.println("------------------切面拦截成功----------------");
    }

//    @Around("pointCut()")
//    public void around(ProceedingJoinPoint point) {
//        log.info("-------------------方法调用前-----------------");
//        try {
//            point.proceed();
//        } catch (Throwable throwable) {
//            log.info("方法异常------------------");
//        }
//        log.info("--------------方法调用结束----------------");
//    }


}
