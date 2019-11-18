package com.tron.web.config;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("-------------------自定义拦截器MyFilter初始化init--------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("----------------doFilter过滤权限--------------");
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest springRequest = sra.getRequest();
        springRequest.setAttribute("userName","tron");
        System.out.println(springRequest.getRequestURI());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("-------------------自定义拦截器MyFilter destroy-------------------");
    }
}
