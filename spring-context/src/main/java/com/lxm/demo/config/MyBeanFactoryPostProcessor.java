package com.lxm.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		System.out.println("2222222222222222222");
		
		Object bean = beanFactory.getBean("userInfo");
		
		System.out.println(bean);
		
	}

}
