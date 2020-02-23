package com.lxm.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "用户表")
public class User {
	
	@ApiModelProperty("用户名")
	private String userName;
	
	@ApiModelProperty("用户密码")
	private String passWord;
	
}



