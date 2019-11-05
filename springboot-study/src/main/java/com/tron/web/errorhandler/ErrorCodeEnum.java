package com.tron.web.errorhandler;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */
public enum ErrorCodeEnum {
    INNER_ERROR(400,"客户端错误"),
    SERVER_ERROR(500,"服务端报错")
    ;

    private Integer code;
    private String msg;

    private ErrorCodeEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
