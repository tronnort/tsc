package com.tron.auth.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @auther tron
 * @create 2019-11-11
 */
public class MyClientDetails implements ClientDetails {
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    /**
     * 客户端id
     */
    private String clientId;
    /**
     * 客户端密码
     */
    private String secret;
    /**
     * 是否验证密码
     */
    private Boolean secretRequired;
    /**
     * 请求校验类型
     */
    private Set authorizedGrantTypes;
    /**
     *  访问范围
     */
    private Set scopes;
    /**
     * 权限信息
     */
    private List authorities;
    /**
     * 验证码有效时间
     */
    private Integer accessTokenValiditySeconds;
    /**
     * 刷新验证码有效时间
     */
    private Integer refreshTokenValiditySeconds;
    /**
     * 是否自动授权
     */
    private Boolean autoApprove;

    public MyClientDetails(String clientId, String secret, Boolean secretRequired, Set authorizedGrantTypes, Set scopes, List authorities, Integer accessTokenValiditySeconds, Integer refreshTokenValiditySeconds, Boolean autoApprove) {
        this.clientId = clientId;
        this.secret = bCryptPasswordEncoder.encode(secret);
        this.secretRequired = secretRequired;
        this.authorizedGrantTypes = authorizedGrantTypes;
        this.scopes = scopes;
        this.authorities = authorities;
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
        this.autoApprove = autoApprove;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return null;
    }

    @Override
    public boolean isSecretRequired() {
        return secretRequired;
    }

    @Override
    public String getClientSecret() {
        return secret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return scopes;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return autoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}
