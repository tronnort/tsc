package com.tron.web.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */

@RestController
@Validated
public class TestController {

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
