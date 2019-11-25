package com.tron.base;

public class BaseException extends RuntimeException {
    private Integer code;
    //方法参数可以是枚举
    public BaseException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
        this.code = baseEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }
}
