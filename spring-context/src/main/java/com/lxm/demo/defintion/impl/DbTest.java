package com.lxm.demo.defintion.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lxm.demo.config.AppConfig;

public class DbTest {
	
	@Test
	public void test1() {
		
		/**
		 * 1、实现SpringBoot里DataSource数据源注入
		 */
		
		
		ApplicationContext context = 
					new AnnotationConfigApplicationContext(AppConfig.class);
	}

}
