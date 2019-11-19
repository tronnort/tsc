package com.tron.web.config;

import com.tron.web.errorhandler.MyException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MyOncePerRequestFilter extends OncePerRequestFilter implements ApplicationContextAware,BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    @Autowired
    MyEnvironment myEnvironment;

    /**
     *
     * 先进该方法读取配置文件，判断时候拦截
     *
     * */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        //读取配置文件，或者从数据源获取
        System.out.println(myEnvironment);
        List<String> strings = Arrays.asList("/dataTest06");
        if (strings.contains(request.getRequestURI())){
            return false;
        }
        return false;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("--------------MyOncePerRequestFilter-----------------------------");
        //这里抛异常，或者response回写数据，依然还会进myFilter
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
//        String msg = "程序出现了未知故障";
//        response.getWriter().write("{\"msg\":"+msg+",\"code\":400}");
        String userName = (String) request.getAttribute("userName");
        System.out.println(userName);
        filterChain.doFilter(request,response);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
}
