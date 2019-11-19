package com.tron.base;

public class BaseException extends RuntimeException {
    private Integer code;
    //方法参数可以是枚举
    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}
