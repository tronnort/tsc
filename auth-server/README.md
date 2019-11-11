```text
注意这三种方法都需要 Basic auth  （客户端id+password）

localhost:8080/oauth/token 申请令牌（post）
grant_type   password
username     xxx
password     xxx

localhost:8080/oauth/check_token?token=   校验令牌（get）

localhost:8080/oauth/token   刷新令牌（post）
grant_type    refresh_token
refresh_token  xxx
```

```text
jwt信息组装源码
DefaultAccessTokenConverter
    ---convertAccessToken
```