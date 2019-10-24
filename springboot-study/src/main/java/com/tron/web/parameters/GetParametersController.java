package com.tron.web.parameters;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class GetParametersController {


    /***
     * localhost:8080/dataTest01? a=a &b=1 &c=false &d=1,2,3 &e={name:"tron"}   psot get 均可
     */
    @RequestMapping("/dataTest01")
    public Object dataTest01(String a, Integer b, boolean c,int[] d, Object e) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Arrays.toString(d));
        System.out.println(e);
        return "success";
    }


    /**
     * localhost:8080/dataTest02/1     post  get  均可
     * */
    @RequestMapping("/dataTest02/{data}")
    public Object dataTest02(@PathVariable(name = "data") String otherData) {
        System.out.println(otherData);
        return "success";
    }

    /**
     * localhost:8080/dataTest03/1     post  get  均可
     * */
    @RequestMapping("/dataTest03/{data}")
    public Object dataTest03(@PathVariable(value = "data") String otherData) {
        System.out.println(otherData);
        return "success";
    }


    /**
     * localhost:8080/dataTest04/1   post get 均可
     * */
    @RequestMapping("/dataTest04/{data}")
    public Object dataTest04(@PathVariable String data) {
        System.out.println(data);
        return "success";
    }


    /**
     * localhost:8080/dataTest05 ?name=tron &age=18 &friends=a,b,c &marry=false    post get 均可
     * localhost:8080/dataTest05   form表单  成功
     * JSON ------------------数据传输失败---------------------
     * */
    @RequestMapping("/dataTest05")
    public Object dataTest05(Person person) {
        System.out.println(person);
        return "success";
    }


    /**
     * localhost:8080/dataTest06 ?name=tron &age=18 &friends=a,b,c &marry=false    post get 均可
     * localhost:8080/dataTest05   -----------------form表单传输失败--------------------
     * JSON 数据 成功
     {
     "name":"tron",
     "age":18,
     "marry":false,
     "friends":["a","b","c"]
     }
     * */
    @RequestMapping("/dataTest06")
    public Object dataTest06(@RequestBody Person person) {
        System.out.println(person);
        return "success";
    }
}
