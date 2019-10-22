package com.tron.web.ErrorHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler({})   //可以指定异常类型，也可以默认所有异常都按此方法处理
    public Map<String, Object> errorHandler(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", e.getCause());
        map.put("msg", e.getMessage());
        return map;
    }
}
