package com.tron.web.resttemplate;

import com.tron.web.parameters.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class TronRestController {

    RestTemplate restTemplate = new RestTemplate();


    /**
     *
     * getForObject使用占位符传值
     *
     * */
    @RequestMapping("/restTest01")
    public Object restTest01() {
        String result = restTemplate.getForObject("http://localhost:8080/forRestTest01?ids={1},{2},{3}", String.class, "1","2","3");
        return result;
    }


    /**
     *
     * getForObject使用占位符map传值
     *
     * */
    @RequestMapping("/restTest02")
    public Object restTest02() {
        HashMap<String,String[]> map = new HashMap<>();
        map.put("ids",new String[]{"1","2","3"});
        String result = restTemplate.getForObject("http://localhost:8080/forRestTest02?ids={ids}", String.class, map);
        return result;
    }


    /**
     *
     * getForObject使用占位符传值
     *
     * */
    @RequestMapping("/restTest03")
    public Object restTest03() {
        String result = restTemplate.getForObject("http://localhost:8080/forRestTest03?name={1}&age={2}", String.class, "tron",18);
        return result;
    }

    /**
     *
     * getForObject使用占位符map传值
     *
     * */
    @RequestMapping("/restTest04")
    public Object restTest04() {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name", "tron");
        map.put("age", 18);
        String result = restTemplate.getForObject("http://localhost:8080/forRestTest04?name={name}&age={age}", String.class, map);
        return result;
    }


    /**
     *
     * postForObject
     *
     * */
    @RequestMapping("/restTest05")
    public Object restTest05() {
        Person person = new Person();
        person.setAge(18);
        person.setMarry(false);
        person.setName("tron");
        String result = restTemplate.postForObject("http://localhost:8080/forRestTest05",person,String.class);
        return result;
    }

    /**
     *
     * postForObject
     *
     * */
    @RequestMapping("/restTest06")
    public Object restTest06() {
        Person person = new Person();
        person.setAge(18);
        person.setMarry(false);
        person.setName("tron");
        String result = restTemplate.postForObject("http://localhost:8080/forRestTest06?id={1}",person,String.class,"001");
        return result;
    }


    /**
     *
     * postForObject
     *
     * */
    @RequestMapping("/restTest07")
    public Object restTest07() {
        Person person = new Person();
        person.setAge(18);
        person.setMarry(false);
        person.setName("tron");

        HashMap<String, Object> map = new HashMap<>();
        map.put("person", person);
        map.put("id", "001");
        String result = restTemplate.postForObject("http://localhost:8080/forRestTest07",map,String.class);
        return result;
    }
}
