package com.tron.configexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TronController {

    @Autowired
    private Tron tron;

    @GetMapping("/getTron")
    public Object getTron() {
        return tron;
    }
}
