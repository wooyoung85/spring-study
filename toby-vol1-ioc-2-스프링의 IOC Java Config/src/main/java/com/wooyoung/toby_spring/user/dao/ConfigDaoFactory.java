package com.wooyoung.toby_spring.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class ConfigDaoFactory {
	@Bean
	public UserDao userDao() {
		//return new UserDao(connectionMaker());
		UserDao userDao = new UserDao();
		userDao.setDataSource(dataSource());
		return userDao;
	}
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/studydb?useSSL=false&serverTimezone=UTC");
		dataSource.setUsername("study");
		dataSource.setPassword("1111");
		
		return dataSource;
	}
}
