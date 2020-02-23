package com.lxm.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled = true) //open base methond security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	public PasswordEncoder passwordEncoder;
	
	/*
	 * @Bean public AuthenticationManager authenticationManager() throws Exception {
	 * return super.authenticationManagerBean(); }
	 */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder);
		System.out.println(passwordEncoder.encode("111"));
		System.out.println(passwordEncoder.encode("111"));
		System.out.println(passwordEncoder.encode("111"));
		System.out.println(passwordEncoder.encode("111"));
		System.out.println(passwordEncoder.encode("111"));
		System.out.println(passwordEncoder.encode("111"));
		System.out.println(passwordEncoder.encode("111"));
		auth.inMemoryAuthentication()
			.withUser("lxm")
			.password(passwordEncoder.encode("123"))
			.roles("admin")
			.authorities("p1","p2");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/login","/swagger-ui.html","/oauth2/**")
			.permitAll()
			.antMatchers(SwaggerConfig.AUTH_WHITELIST)
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.and()
		/* .httpBasic() */;
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//super.configure(web);
		web.ignoring().antMatchers("/css/**","/js/**","/img/**","/webjars/*","/static/**","/*.js");
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	
}
