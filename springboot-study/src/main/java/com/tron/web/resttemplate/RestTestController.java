package com.tron.web.resttemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.tron.web.parameters.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@Slf4j
public class RestTestController {

    @RequestMapping("/forRestTest01")
    public String forRestTest01( String[] ids) {
        System.out.println(Arrays.asList(ids));
        return "success";
    }

    @RequestMapping("/forRestTest02")
    public String forRestTest02(String[] ids) {
        System.out.println(Arrays.asList(ids));
        return "success";
    }

    @RequestMapping("/forRestTest03")
    public String forRestTest03(String name,Integer age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("/forRestTest04")
    public String forRestTest04(String name,Integer age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping("/forRestTest05")
    public String forRestTest05(@RequestBody Person person) {
        System.out.println(person);
        return "success";
    }

    @RequestMapping("/forRestTest06")
    public String forRestTest06(@RequestBody Person person,String id) {
        System.out.println(person);
        System.out.println(id);
        return "success";
    }

    @RequestMapping("/forRestTest07")
    public String forRestTest07(@RequestBody Map<String,Object> map) {
        Object o = map.get("person");
        Person person = JSON.parseObject(JSON.toJSONString(o), Person.class);
        String id = (String) map.get("id");
        System.out.println(person);
        System.out.println(id);
        return "success";
    }
}
