package com.tron.web.validation;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @Description
 * @auther tron
 * @create 2019-11-18
 */
@Data
public class MyData implements Supplier<Map<String,String>> {
    private String msg;
    private Integer code;


    @Override
    public Map<String, String> get() {
        HashMap<String, String> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("这是自定义的错误信息");
        map.put("msg", stringBuilder.toString());
        map.put("result", "false");
        return map;
    }
}
