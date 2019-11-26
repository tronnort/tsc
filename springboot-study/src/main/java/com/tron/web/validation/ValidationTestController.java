package com.tron.web.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */

@RestController
@Validated
public class ValidationTestController {

    @PostMapping("/test")
    public String say(@Validated(value = {UpdateGroup.class}) @RequestBody Person person ) {
        return person.getName();
    }


    //http://localhost:8080/test1?msg=tron&code=1 校验失败
    @GetMapping("/test1")
    public String singerValue(@CheckCase MyData myData) {
        return "success";
    }
}
