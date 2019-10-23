package com.tron.web.validation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    public String say(@Validated({UpdateGroup.class}) Person person ) {
        return person.getName();
    }

    @RequestMapping("/test1")
    public String singerValue(@NotBlank(message = "str字符不能为空") String string) {
        return "success";
    }
}
