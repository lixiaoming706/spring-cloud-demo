package com.lxm.user.center;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringUserServiceApplicationTest {
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testDataSource() {
		System.out.println("111111111111111111111");
		System.out.println(dataSource);
		System.out.println(dataSource);
		System.out.println(dataSource);
		System.out.println(dataSource);
		System.out.println(dataSource);
	}
}
