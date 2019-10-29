package com.tron.web.ErrorHandler;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler({})   //可以指定异常类型，也可以默认所有异常都按此方法处理
    public Map<String, Object> errorHandler(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        if (e instanceof MyException) {
            MyException  myException = (MyException)e;
            map.put("code",myException.getCode());
        }else if (e instanceof BindException){
            StringBuffer stringBuffer = new StringBuffer();
            BindException bindException = (BindException) e;
            List<ObjectError> allErrors = bindException.getAllErrors();
            allErrors.forEach(x-> stringBuffer.append(x.getObjectName()).append(x.getDefaultMessage()).append(","));
            map.put("msg", stringBuffer.toString());
            map.put("code", 400);   //参数校验异常
            return map;
        }else {
            map.put("code", 911);   //处理非自定异常时的默认code
        }
        map.put("msg", e.getMessage());
        return map;
    }

}
