package com.tron.myenum;

public enum MyEnum {

    SUCCESS("成功",200),
    BUSY("服务正忙，请稍后再试！",402)
    ;
    private String msg;
    private Integer code;
    MyEnum(String msg,Integer code){
        this.msg = msg;
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
