--------------------------SpringContext init-----------------------

public AnnotationConfigApplicationContext(Class<?>... componentClasses) {
	this();  
	register(componentClasses); //注册启动类
	refresh();  // 刷新容器
}


PostProcessor:后置处理器


BeanDefinitionRegistryPostProcessor[interface]
	->[org.springframework.context.annotation.internalConfigurationAnnotationProcessor]
	
BeanFactoryPostProcessor
	->[org.springframework.context.annotation.internalConfigurationAnnotationProcessor, 
		org.springframework.context.event.internalEventListenerProcessor]
		
BeanPostProcessor		