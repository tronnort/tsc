package com.tron.web.resttemplate;

import com.tron.web.parameters.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
        String result = restTemplate.getForObject("http://localhost:8080/forRestTest01?ids={1},{2},{3}", String.class, "6","5","9");
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



    /**
     *
     * postForObject文件操作
     *
     * */
    @RequestMapping("/restTest08")
    public String restTest08(@RequestBody MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();//name
        String tempFilePath = "/home/tron/" + file.getOriginalFilename();
        File tempFile = new File(tempFilePath);
        try {
            file.transferTo(tempFile);//生成临时文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取文件属性（还要额外形参这里就不给出了） 一系列的存表 操作
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.setContentType(MediaType.parseMediaType("multipart/form-data;charset=UTF-8"));
        MultiValueMap<String,Object> param = new LinkedMultiValueMap<>();
        //MultipartFile 直接转 fileSystemResource 是不行的
        FileSystemResource resource = new FileSystemResource(tempFilePath);//把临时文件变成filesystemresource
        param.add("file", resource);
        HttpEntity<MultiValueMap<String,Object>> formEntity = new HttpEntity<>(param,headers);
        String s = restTemplate.postForObject("http://localhost:8080/forRestTest08", formEntity, String.class);
        System.out.println(s);
        tempFile.delete();
        return "fileUrl";
    }
}
