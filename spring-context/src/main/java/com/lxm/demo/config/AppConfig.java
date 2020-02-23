package com.lxm.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Role;
import org.springframework.scheduling.annotation.Async;

import com.lxm.demo.beans.Book;
import com.lxm.demo.beans.User;
import com.lxm.demo.defintion.DataSource;

@Configuration
@ImportResource("classpath:/beans.xml")
@Import({MyApplicationContext.class,
		MyBeanDefinitionRegistryPostProcessor.class,
		MyBeanFactoryPostProcessor.class,
		MyImportSelector.class,
		MyImportBeanDefinitionRegistrar.class,
		MyApplicationListener.class
})
@EnableAspectJAutoProxy
@ComponentScan({"com.lxm.demo.aop","com.lxm.demo.tx"})
public class AppConfig {
	
	@Bean("userInfo")
	public User user() {
		return new User();
	}
	
	@Bean
	//@Role
	@Conditional(value = {MyCondition.class})
	public Book book() {
		return new Book();
	}
	
	@Bean
	public DataSource dataSource() {
		return null;
	}
}
