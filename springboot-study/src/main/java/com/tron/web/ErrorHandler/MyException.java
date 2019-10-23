package com.tron.web.ErrorHandler;

public class MyException extends RuntimeException {
    private Integer code;
    //方法参数可以是枚举
    public MyException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
