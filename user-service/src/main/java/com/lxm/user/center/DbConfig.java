package com.lxm.user.center;


import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DbConfig {
//	
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix="spring.datasource.c3p0") // 配置属性
	public DataSource dataSource(){
		
		return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
	
	}
}
