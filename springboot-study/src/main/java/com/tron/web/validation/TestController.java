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

    @GetMapping("/test1")
    public String singerValue(@CheckCase(message = "str字符不能为空") String value) {
        return "success";
    }
}
