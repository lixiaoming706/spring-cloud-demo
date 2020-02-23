package com.lxm.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;





@SpringBootApplication
@EnableZipkinServer
public class SpringZipkinApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringZipkinApplication.class, args);
	}
}
