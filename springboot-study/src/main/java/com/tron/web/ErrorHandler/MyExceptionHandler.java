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
        MyException myException;
        HashMap<String, Object> map = new HashMap<>();
        if (e instanceof MyException) {
            myException = (MyException)e;
            map.put("code",myException.getCode());
        }else {
            map.put("code", 911);   //处理非自定异常时的默认code
        }
        map.put("msg", e.getMessage());
        return map;
    }
}
