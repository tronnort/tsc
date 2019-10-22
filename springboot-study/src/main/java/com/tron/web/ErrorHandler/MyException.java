package com.tron.web.ErrorHandler;

public class MyException extends RuntimeException {
    public MyException() {
        super("自定义错误信息");
    }
}
