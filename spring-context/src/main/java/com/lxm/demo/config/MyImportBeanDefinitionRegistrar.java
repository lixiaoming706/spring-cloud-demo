package com.lxm.demo.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.lxm.demo.beans.Role;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	
	public  void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		
		RootBeanDefinition beanDefinition = new RootBeanDefinition(Role.class);
		
		registry.registerBeanDefinition("lxm", beanDefinition);
	}

}
