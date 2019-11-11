package com.tron.auth.config;

import com.tron.auth.service.MyUserAuthenticationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.annotation.Resource;
import java.security.KeyPair;


/**
 * @program: TRON
 * @description:
 * @author: TRON
 * @create: 2019-09-17 13:58
 */
//认证服务端配置
@Configuration
@EnableAuthorizationServer
public class MyOauth2Config extends AuthorizationServerConfigurerAdapter {


    @Bean("keyProp")
    public KeyProperties keyProperties(){
        return new KeyProperties();
    }

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("myUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("myClientDetailsService")
    ClientDetailsService clientDetailsService;

    @Autowired
    TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetailsService);

//        clients.inMemory()
//                .withClient("test")
//                .secret(bCryptPasswordEncoder.encode("123456"))
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("server")
//                .accessTokenValiditySeconds(36000)
//        ;
    }

    //授权服务器端点配置
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)//认证管理
                .userDetailsService(userDetailsService)//用户认证管理
                .accessTokenConverter(jwtAccessTokenConverter())
                .tokenStore(tokenStore)//令牌存储
        ;
    }


    //授权服务器的安全配置
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .checkTokenAccess("isAuthenticated()")//校验token需要认证通过，可采用http basic认证
                .tokenKeyAccess("permitAll()")
        ;
    }


    @Bean
    @Autowired
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }


    @Bean
    protected JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyProperties.KeyStore keyProp = keyProperties.getKeyStore();
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(keyProp.getLocation().getFilename()), keyProp.getSecret().toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(keyProp.getAlias(), keyProp.getPassword().toCharArray());
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setKeyPair(keyPair);
        //配置自定义的UserAuthenticationConverter,可以自定义封装jwt的返回数据
        DefaultAccessTokenConverter defaultAccessTokenConverter = new DefaultAccessTokenConverter();
        defaultAccessTokenConverter.setUserTokenConverter(new MyUserAuthenticationConverter());
        converter.setAccessTokenConverter(defaultAccessTokenConverter);
        return converter;
    }

}
