package com.lxm.demo.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;




public class MyApplicationContext extends AbstractApplicationContext {
	
	
	protected void initPropertySources() {
		
		System.out.println("子容器的initPropertySources方法");
		
	}
	
	
	
	@Override
	protected void refreshBeanFactory() throws BeansException, IllegalStateException {
		
		
		
		System.out.println("11111111111111111111111111111111111");
		
	}

	@Override
	protected void closeBeanFactory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
