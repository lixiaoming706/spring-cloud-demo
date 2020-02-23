package com.lxm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class SpringSecurityOAuth2Applicaton {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringSecurityOAuth2Applicaton.class, args);
	}

}
