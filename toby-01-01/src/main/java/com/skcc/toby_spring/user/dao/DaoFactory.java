package com.skcc.toby_spring.user.dao;

public class DaoFactory {

	public UserDao userDao() {		
		//UserDao userDao = new UserDao(connectionMaker());
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}
	
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
