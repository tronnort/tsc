package com.tron.auth.service;

import com.tron.auth.entity.MyClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description
 * @auther tron
 * @create 2019-11-11
 */
@Service
public class MyClientDetailsService implements ClientDetailsService {

    /**
     *
     * 用户调用login登录前会进入该方法,clientId为分配的客户端账号
     *
     * */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        //TODO 根据clientId 从数据库中查出客户端信息
        HashSet<String> scopes = new HashSet<>();
        scopes.add("server");
        HashSet<String> authorizedGrantTypes = new HashSet<>();
        authorizedGrantTypes.add("password");
        authorizedGrantTypes.add("refresh_token");
        ArrayList<String> authorities = new ArrayList<>();
        MyClientDetails myClientDetails = new MyClientDetails("test", "123456", true, authorizedGrantTypes, scopes, authorities, 3600, 3600, true);
        return myClientDetails;
    }
}
