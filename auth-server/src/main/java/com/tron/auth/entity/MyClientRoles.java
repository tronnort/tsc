package com.tron.auth.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Description
 * @auther tron
 * @create 2019-11-11
 */
public class MyClientRoles implements GrantedAuthority {

    private String roles;

    public MyClientRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String getAuthority() {
        return roles;
    }
}
