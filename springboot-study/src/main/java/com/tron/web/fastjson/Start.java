package com.tron.web.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Description
 * @auther tron
 * @create 2019-11-10
 */
public class Start {
    public static void main(String[] args) {
        JsonBean jsonBean = new JsonBean();
        jsonBean.setB(false).setI(1).setS("s").setM(new HashMap()).setL(Arrays.asList("1"));
        String jb = JSON.toJSONString(jsonBean);

        System.out.println(jb);

        JSONObject jsonObject = JSON.parseObject(jb);
        System.out.println(jsonObject.get("s"));
        System.out.println(jsonObject.get("i"));
        System.out.println(jsonObject.get("m"));
        System.out.println(jsonObject.get("l"));
        System.out.println(jsonObject.get("b"));
    }
}
