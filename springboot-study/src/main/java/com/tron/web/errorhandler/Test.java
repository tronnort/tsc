package com.tron.web.errorhandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("/")
    public Object test(String str) {
        //简单类型的错误
//        Assert.notNull(str,"需要传入一个非空字符");
        if (true){
              /*
              * 使用枚举可以在统一的地址控制错误信息的返回值，在自定义异常的时候直接把枚举当参数传递。
              * 但是assert并不支持枚举，需要使用assert的简单校验时需要做特殊处理
              * */
//            ErrorCodeEnum innerError = ErrorCodeEnum.INNER_ERROR;
//            Integer code = innerError.getCode();
//            String msg = innerError.getMsg();
            throw new MyException(400,ErrorCodeMap.INNER_ERROR400);
        }
        return "null";
    }
}
