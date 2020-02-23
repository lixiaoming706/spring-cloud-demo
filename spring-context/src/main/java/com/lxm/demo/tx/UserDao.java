package com.lxm.demo.tx;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insert() {
		
		String sql = "INSERT INTO Test(userName,userPass,age,email) VALUES (?,?,'15','1111@163.com');";
		
		jdbcTemplate.update(sql, UUID.randomUUID().toString(),"123456");
	}
}
