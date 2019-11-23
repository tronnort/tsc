package com.tron.feign.config;

import feign.FeignException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description TODO
 * @auther gaoli
 * @create 2019-11-23
 */
@ControllerAdvice
public class FeignExceptionHandler {

    @ResponseBody
    @ExceptionHandler({})
    public Object SocketTimeoutException(Exception e) {
        if (e instanceof FeignException) {
            System.out.println("服务异常--------------"+e.getMessage());
        }
        return "服务异常，请稍后再试";
    }
}
