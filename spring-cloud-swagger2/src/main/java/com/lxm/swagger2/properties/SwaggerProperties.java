package com.lxm.swagger2.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.demo.swagger")
public class SwaggerProperties {
	
	private String backPage = "com.lxm.demo";
	
	private String groupName = "lxm";
	
	private String apiTitle = "李晓明";
	
	private String apiDescription = "接口api文档";
	
	private String apiVersion = "Demo 1.0";
	

	public String getBackPage() {
		return backPage;
	}

	public void setBackPage(String backPage) {
		this.backPage = backPage;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getApiTitle() {
		return apiTitle;
	}

	public void setApiTitle(String apiTitle) {
		this.apiTitle = apiTitle;
	}

	public String getApiDescription() {
		return apiDescription;
	}

	public void setApiDescription(String apiDescription) {
		this.apiDescription = apiDescription;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	
	
}
