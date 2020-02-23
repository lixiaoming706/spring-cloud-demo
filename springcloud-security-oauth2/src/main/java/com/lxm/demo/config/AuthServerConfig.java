package com.lxm.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.servlet.support.RequestContext;


@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private ClientDetailsService clientDetailsService;
	
	@Autowired
	private AuthorizationCodeServices authorizationCodeServices;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtAccessTokenConverter jwtAccessTokenConverter;
	
	 /**
	 * 配置令牌端点安全约束
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
				// 开启/oauth/token_key验证端口无权限访问
				.tokenKeyAccess("permitAll()")
				// 开启/oauth/check_token验证端口认证权限访问
		 .checkTokenAccess("permitAll()") 
				
		/* .allowFormAuthenticationForClients() */;
	}
	
	
	//配置客户端详情
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
			.inMemory()
			.withClient("appId")
			.resourceIds("r1","r2")
			.secret(passwordEncoder.encode("123"))
			.redirectUris("http://www.baidu.com")
			.authorizedGrantTypes("authorization_code","password","implicit","client_credentials","refresh_token")//四种授权模式
			.autoApprove(false) //false 跳转到授权页面
			.scopes("all");
		
	}
	
	@Bean
	public DefaultTokenServices tokenServices() {
		
		DefaultTokenServices tokenServices = new DefaultTokenServices();
		
		tokenServices.setClientDetailsService(clientDetailsService);
		tokenServices.setTokenStore(tokenStore);
		tokenServices.setRefreshTokenValiditySeconds(72000);
		tokenServices.setAccessTokenValiditySeconds(72000);
		tokenServices.setSupportRefreshToken(true);
		
		
		//增強令牌实现jwt
		TokenEnhancerChain accessTokenEnhancer = new TokenEnhancerChain();
		accessTokenEnhancer.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
		tokenServices.setTokenEnhancer(accessTokenEnhancer);
		
		return tokenServices;
		
	}
	
	/**
	 * 配置端点
	 */
	@Override 
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenServices(tokenServices())
			.reuseRefreshTokens(true)
			.authenticationManager(authenticationManager)
			.authorizationCodeServices(authorizationCodeServices);
	}
	
}
