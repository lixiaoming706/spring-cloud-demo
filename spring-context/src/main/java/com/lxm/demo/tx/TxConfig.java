package com.lxm.demo.tx;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 加上事务控制
 * @author Administrator
 *
 */

@EnableTransactionManagement //开始基于注解的事务管理功能
@Configuration
public class TxConfig {
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource cpd = new ComboPooledDataSource();
		cpd.setUser("root");
		cpd.setPassword("123");
		try {
			cpd.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		cpd.setJdbcUrl("jdbc:mysql://localhost:3306/Test");
		return cpd;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}
	
	@Bean
	public TransactionManager transactionManager(DataSource ds) {
		
		DataSourceTransactionManager dstm 
			= new DataSourceTransactionManager(ds);
		return dstm;
	}
}
