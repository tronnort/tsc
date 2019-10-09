package com.tron.auth.controller;

import com.tron.auth.entity.AuthToken;
import com.tron.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther tron
 * @create 2019-10-09
 */
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @RequestMapping("/userLogin")
    public Object userLogin(String username,String password) {
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);
        return authToken;
    }
}
