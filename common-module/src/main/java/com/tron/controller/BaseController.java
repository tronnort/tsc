package com.tron.controller;

import com.tron.myenum.MyEnum;
import lombok.Data;

public class BaseController {

    protected  <T> FinalResult buildFinalResult(T t, MyEnum myEnum) {
        return  new FinalResult(t,myEnum.getCode(),myEnum.getMsg());
    }

    @Data
    public class FinalResult<T>{
        private Integer code;
        private String msg;
        private T data;
        public FinalResult(T t,Integer code,String msg) {
            data = t;
            this.code = code;
            this.msg = msg;
        }
    }

}
