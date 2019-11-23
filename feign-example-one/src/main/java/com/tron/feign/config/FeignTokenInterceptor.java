package com.tron.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @description feign调用服务时，会丢失请求头信息。需要在这里把认证信息收到添加上去
 * @auther gaoli
 * @create 2019-11-23
 */
@Component
public class FeignTokenInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (null == getHttpServletRequest()) {
            return;
        }
        HttpServletRequest httpServletRequest = getHttpServletRequest();
        String token = httpServletRequest.getHeader("abc");
        requestTemplate.header("abc", token);
    }

    private HttpServletRequest getHttpServletRequest() {
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
            return servletRequestAttributes.getRequest();
        } catch (Exception e) {
            // TODO: 2019/11/23 获取请求失败处理
            throw new RuntimeException("------------------------");
        }
    }
}
