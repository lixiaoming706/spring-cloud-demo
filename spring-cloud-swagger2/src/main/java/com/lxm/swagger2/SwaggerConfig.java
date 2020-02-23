package com.lxm.swagger2;

import java.util.ArrayList;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.lxm.swagger2.properties.SwaggerProperties;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration("SwaggerAutoConfiguration")
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig {
	

	private  final SwaggerProperties swaggerProperties ;
	
	public SwaggerConfig(SwaggerProperties swaggerProperties) {
		this.swaggerProperties = swaggerProperties;
	}
	
	@Bean
	public Docket docket(Environment environment) {
		
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())	//配置Swagge信息
					.groupName(this.swaggerProperties.getGroupName())
					.enable(true)
					.select() //配置Swagger的扫描接口
					//any() 扫描全部
					//basePackage("") 扫描包
					//none() 都不扫描
					.apis(RequestHandlerSelectors.basePackage(this.swaggerProperties.getBackPage()))
					.paths(PathSelectors.any()) //扫描路径
					.build();
	}
	
	
	@Bean
	public ApiInfo apiInfo() {
		
		ApiInfo apiInfo = new ApiInfo(this.swaggerProperties.getApiTitle(), 
							this.swaggerProperties.getApiDescription(), this.swaggerProperties.getApiVersion(), "urn:tos",
							new Contact("", "", ""), "Apache 2.0", 
							"http://www.baidu.com", 
							new ArrayList<VendorExtension>());
		return apiInfo;
	}
}
