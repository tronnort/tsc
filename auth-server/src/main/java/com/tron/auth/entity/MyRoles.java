package com.tron.auth.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * @program: TRON
 * @description:
 * @author: TRON
 * @create: 2019-09-16 16:10
 */
public class MyRoles implements GrantedAuthority {
    private String roles;

    public MyRoles(String roles) {
        this.roles = "ROLE_"+roles;
    }

    @Override
    public String getAuthority() {
        return roles;
    }
}
