package com.tron.auth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tron.auth.entity.AuthToken;
import com.tron.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

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


        /*-------------------jwt令牌使用演示start-------------------*/
        //读取公钥
        Resource resource = new ClassPathResource("public.cert");
        String publicKey = null;
        try {
            byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
            publicKey = new String(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过公钥获取jwt信息
        Jwt jwt = JwtHelper.decodeAndVerify(authToken.getJwt_token(), new RsaVerifier(publicKey));
        //{"cnName":"真武幻","user_name":"user","scope":["server"],"exp":1573457424,"authorities":["ROLE_USER"],"jti":"0c1bb8ac-fee6-4e61-aaf8-aade6d0c4f01","client_id":"test"}
        System.out.println(jwt.getClaims());
        //转json对象
        JSONObject jsonObject = JSON.parseObject(jwt.getClaims());
        //获取用户信息
        String cnName = (String) jsonObject.get("cnName");
        List<String> authorities = (List) jsonObject.get("authorities");

        System.out.println(cnName);
        System.out.println(authorities);
        /*-------------------jwt令牌使用演示end-------------------*/

        //这里可以返回用户基础信息和 jti令牌给前端,前端调用资源服务时携带jti立牌,资源服务器,通过jti令牌从redis中获取jwt令牌中的用户权限信息
        return authToken;
    }
}
