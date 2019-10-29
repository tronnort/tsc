package com.tron.web.common;

import lombok.Data;

public class BaseController {
    public  SuccessResult successResult;

    public <T> SuccessResult  buildSuccessResult(T t) {
        this.successResult = new SuccessResult(t);
        return successResult;
    }

    @Data
    public class  SuccessResult<T>{
        private final String code = "200";
        private T data;
        public SuccessResult(T t) {
            data = t;
        }
    }

}
