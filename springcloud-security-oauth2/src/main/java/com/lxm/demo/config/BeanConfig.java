package com.lxm.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class BeanConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
	
	@Primary
	@Bean
	public TokenStore tokenStore2() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public AuthorizationCodeServices inMemoryAuthorizationCodeServices() {
		return new InMemoryAuthorizationCodeServices();
	}
	@Primary
	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		
		JwtAccessTokenConverter jtc = new JwtAccessTokenConverter();
		jtc.setSigningKey("lxm");
		return jtc;
	}
}
