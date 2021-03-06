package com.lxm.web.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages= {"com.lxm.web.client.dao"})
public class SpringWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}
}
