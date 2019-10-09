package com.tron.auth.entity;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: TRON
 * @description: 自定义jwt令牌中需要封装的信息。
 * @author: TRON
 * @create: 2019-09-20 11:19
 */

@Component
public class MyUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        assert authentication.getName() != null;
        Object principal = authentication.getPrincipal();
        MyUserDetails myUserDetails = (MyUserDetails) principal;
        LinkedHashMap<String, Object> response = new LinkedHashMap<>();
        response.put("user_name",myUserDetails.getUsername());
        response.put("cnName",myUserDetails.getCnName());
        response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
        return response;
    }
}
