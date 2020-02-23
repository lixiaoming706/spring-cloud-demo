package com.lxm.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private String resourceId = "r1";

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	DefaultTokenServices tokenServices;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

		resources.resourceId(resourceId).tokenServices(tokenServices).stateless(true);
		/**
		 resources.resourceId(resourceId).tokenStore(tokenStore).stateless(true);
		 */
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().disable().authorizeRequests().antMatchers("/**").authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	/*
	 * @Bean
	 * 
	 * @Primary public ResourceServerTokenServices tokenServicesEx() {
	 * DefaultTokenServices service = new DefaultTokenServices();
	 * service.setTokenStore(tokenStore); return service; }
	 */
	
}
