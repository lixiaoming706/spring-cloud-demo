package com.lxm.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		
		configurer.enable();
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/templates/", ".jsp");
	}
	
	
	
	
}
