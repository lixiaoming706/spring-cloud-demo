package com.lxm.demo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	protected static final String[] AUTH_WHITELIST = {
			 
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };
	
	@Bean
	public Docket docket(Environment environment) {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()) // 配置Swagge信息
				.groupName("lxm").enable(true).select() // 配置Swagger的扫描接口
				// any() 扫描全部
				// basePackage("") 扫描包
				// none() 都不扫描
				.apis(RequestHandlerSelectors.basePackage("com.lxm.demo.cotroller"))
				.paths(PathSelectors.any()) // 扫描路径
				.build();
	}

	@Bean
	public Docket docket2() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("xwl");
	}

	@Bean
	public ApiInfo apiInfo() {

		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo("李晓明的api文档", "Api Documentation", "1.0", "urn:tos", new Contact("", "", ""),
				"Apache 2.0", "http://www.baidu.com", new ArrayList<VendorExtension>());
		return apiInfo;
	}

	// 配置实体类，只要我们的接口中调用哪个实体，该实体就会加载在swagger
	// @ApiModel 、@ApiModelPropert

	// 相关注解
	// @ApiParam -- 参数
	// @ApiOperation -- 方法描述
}
