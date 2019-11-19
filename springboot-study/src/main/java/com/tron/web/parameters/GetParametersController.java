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
     * localhost:8080/dataTest06 ?name=tron &age=18 &friends=a,b,c &marry=false    失败
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

    /**
     * 传参为json格式，接受参数为对象时，需要使用@RequestBody     ["1","2"]
     * localhost:8080/dataTest07?code=111  code可以用普通的url传值方式获取
     * */
    @RequestMapping("/dataTest07")
    public Object dataTest07(@RequestBody String[] ids,String code) {
        return "success";
    }



    /**
     * 无论怎么传值都报错
     * */
    @RequestMapping("/dataTest08")
    public Object dataTest08(@RequestBody String[] ids,@RequestBody String code) {
        return "success";
    }

    /**
     *
     *
     *
     * 注解对比图
     * 区别	                 @RequestParam                    	@RequestBody
     * content-type	     仅支持x-www-form-urlencoded	           json（常用）, xml
     * 请求类型	                所有                           	除了GET
     * 注解个数	               可多个	                        只能有一个
     *
     * */
}
