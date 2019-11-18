package com.tron.base;

import lombok.Data;

public class BaseController {
    public  FinalResult successResult;

    public <T> FinalResult  buildFinalResult(T t) {
        this.successResult = new FinalResult(t);
        return successResult;
    }

    @Data
    public class  FinalResult<T>{
        private final String code = "200";
        private T data;
        public FinalResult(T t) {
            data = t;
        }
    }

}
