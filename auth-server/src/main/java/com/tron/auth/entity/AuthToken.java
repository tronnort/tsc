package com.tron.auth.entity;


import lombok.Data;

/**
 * @program: TRON
 * @description:
 * @author: TRON
 * @create: 2019-09-19 09:19
 */
@Data
public class AuthToken {
    String access_token;//访问token就是短令牌，用户身份令牌
    String refresh_token;//刷新token
    String jwt_token;//jwt令牌
}
