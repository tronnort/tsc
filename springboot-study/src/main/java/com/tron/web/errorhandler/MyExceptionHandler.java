package com.tron.web.errorhandler;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler({MyException.class,MethodArgumentNotValidException.class,BindException.class})   //可以指定异常类型，也可以默认所有异常都按此方法处理
    public Map<String, Object> errorHandler(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        if (e instanceof MyException) {
            MyException  myException = (MyException)e;
            map.put("code",myException.getCode());
        }else if (e instanceof BindException){
            BindException bindException = (BindException) e;
            List<ObjectError> allErrors = bindException.getAllErrors();
            getErrors(map, allErrors);
            return map;
        }else if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException argumentNotValidException = (MethodArgumentNotValidException)e;
            BindingResult bindingResult = argumentNotValidException.getBindingResult();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            getErrors(map, allErrors);
            return map;
        }else {
            map.put("code", 911);   //处理非自定异常时的默认code
        }
        map.put("msg", e.getMessage());
        return map;
    }

    private void getErrors(HashMap<String, Object> map,List<ObjectError> allErrors) {
        StringBuffer stringBuffer = new StringBuffer();
        allErrors.forEach(x -> stringBuffer.append(x.getObjectName()).append(x.getDefaultMessage()).append(","));
        map.put("msg", stringBuffer.toString());
        map.put("code", 400);   //参数校验异常
    }

    @ResponseBody
    @ExceptionHandler({SQLException.class})
    public Map<String, Object> MySQLIntegrityConstraintViolationExceptionHandler(Exception e) {
        HashMap<String, Object> map = new HashMap<>();
        if (e instanceof DuplicateKeyException) {
            map.put("code", 400);
            map.put("msg", "唯一键已存在数据重复");
            return map;
        }
        map.put("code", 401);
        map.put("msg", e.getMessage());
        return map;
    }

}
