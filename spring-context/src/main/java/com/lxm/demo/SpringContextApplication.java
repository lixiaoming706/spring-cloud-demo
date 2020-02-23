package com.lxm.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.env.Environment;

import com.lxm.demo.aop.MathCalculator;
import com.lxm.demo.beans.User;
import com.lxm.demo.config.AppConfig;
import com.lxm.demo.tx.UserService;


@SuppressWarnings("resource")
public class SpringContextApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Environment environment = context.getEnvironment();
		
		
		String os = environment.getProperty("os.name");
		
		User user = context.getBean(User.class);
		
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		
		
		
		  for (String name : beanDefinitionNames) { System.out.println(name); }
		  
		  MathCalculator mc = context.getBean(MathCalculator.class);
		  
		  System.out.println(mc);
		  
		 // mc.div(10, 2);
		/*
		 * System.out.println(os);
		 * 
		 * System.out.println(user);
		 */
		 
		 
		//---------------------aop----------------------------
		
		/*
		 * MathCalculator mc = context.getBean(MathCalculator.class);
		 * 
		 * mc.div(10, 2);
		 */
		
		  UserService userService = context.getBean(UserService.class);
		  
		  userService.insertUser();
	}

}
