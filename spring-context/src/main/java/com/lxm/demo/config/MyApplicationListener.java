package com.lxm.demo.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;


public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		Object source = event.getSource();
		
		System.out.println(source);
	}

}
