package com.tron.web.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCacheController {

    @Autowired
    private TestService testService;

    @RequestMapping("/testCache01")
    public Person testCache01() {
        Person person1 = new Person();
        person1.setId("001");
        Person person = testService.find(person1,"1");
        return person;
    }

    @RequestMapping("/testCache02")
    public Tron testCache02() {
        Tron tron = new Tron();
        tron.setId("001");
        return testService.findTron(tron);
    }

    @RequestMapping("/testCache03")
    public Tron testCache03() {
        Tron tron = new Tron();
        tron.setId("001");
        return testService.updateTron(tron);
    }

    @RequestMapping("/testCache04")
    public void testCache04() {
       testService.deleteTron("001");
    }
}
