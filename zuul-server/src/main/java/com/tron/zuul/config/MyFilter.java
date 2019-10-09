package com.tron.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Description
 * @auther tron
 * @create 2019-10-09
 */
@Component
public class MyFilter extends ZuulFilter {
    public String filterType() {
        return PRE_TYPE;
    }

    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        System.out.println(request.getCookies());
        System.out.println(request.getRequestURI()); //   /auth/api/userLogin
        System.out.println(request.getRequestURL()); //   http://localhost:3000/auth/api/userLogin

//        try {
//            currentContext.setSendZuulResponse(false);
//            HttpServletResponse response = currentContext.getResponse();
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().write("zuul拦截检查权限失败时返回信息");
//        } catch (IOException e) {
//            return null;
//        }
        currentContext.setSendZuulResponse(false);
        currentContext.setResponseStatusCode(401);
        currentContext.setResponseBody("{\"status\":401,\"msg\":\"user is not login !\"}");
        currentContext.getResponse().setContentType("text/html;charset=UTF-8");



        return null;
    }
}
