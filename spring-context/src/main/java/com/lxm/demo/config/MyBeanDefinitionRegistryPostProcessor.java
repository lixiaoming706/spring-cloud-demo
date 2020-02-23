package com.lxm.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;



public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// TODO Auto-generated method stub
		boolean containsBeanDefinition = registry.containsBeanDefinition("userInfo");
		
		
		System.out.println("postProcessBeanDefinitionRegistry===>"+containsBeanDefinition);
		System.out.println("postProcessBeanDefinitionRegistry===>"+containsBeanDefinition);
		System.out.println("postProcessBeanDefinitionRegistry===>"+containsBeanDefinition);
		System.out.println("postProcessBeanDefinitionRegistry===>"+containsBeanDefinition);
		System.out.println("postProcessBeanDefinitionRegistry===>"+containsBeanDefinition);
	
	}

}
