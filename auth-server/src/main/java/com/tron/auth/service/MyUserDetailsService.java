package com.tron.auth.service;

import com.tron.auth.entity.MyRoles;
import com.tron.auth.entity.MyUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @program: TRON
 * @description:
 * @author: TRON
 * @create: 2019-09-16 16:08
 */

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //todo  登录账号从这里取到。根据账号获得用户的权限信息返回用户实体。
        HashSet<MyRoles> myRoles = new HashSet<>();
        myRoles.add(new MyRoles("USER"));
        MyUserDetails myUserDetails = new MyUserDetails("user", "123456","真武幻", myRoles);
        //todo
        return myUserDetails;
    }
}
