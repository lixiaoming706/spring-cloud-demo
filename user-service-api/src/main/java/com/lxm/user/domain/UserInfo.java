package com.lxm.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain= true)
@Entity
@Table(name="users")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
@Proxy(lazy = false)
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="pass_word")
	private String passWord;
	
	private Integer age;
}
