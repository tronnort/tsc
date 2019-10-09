package com.tron.auth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Set;

/**
 * @program: TRON
 * @description:
 * @author: TRON
 * @create: 2019-09-16 16:09
 */

public class MyUserDetails implements UserDetails {
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private String password;
    private String userName;
    //自定义返回的的中文名
    private String cnName;
    private Set<MyRoles> authorities;

    public MyUserDetails(String userName, String password,String cnName, Set<MyRoles> authorities) {
        this.password = bCryptPasswordEncoder.encode(password).trim();
        this.userName = userName;
        this.authorities = authorities;
        this.cnName = cnName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    public String getCnName() {
        return cnName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
