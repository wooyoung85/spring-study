package com.wooyoung.toby_spring;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.wooyoung.toby_spring.user.User;
import com.wooyoung.toby_spring.user.dao.UserDao;

public class UserDaoTest 
{
    @SuppressWarnings("resource")
	public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
    	UserDao dao = context.getBean("userDao", UserDao.class);
    	
    	User user = new User();
    	user.setId("wooyoung85");
    	user.setName("서우영");
    	user.setPassword("1234");
    	
    	dao.add(user);
    	
        System.out.println(user.getId() + "등록 성공!");
        
    	User user2 = dao.get(user.getId());
    	System.out.println(user2.getName());
    	System.out.println(user2.getPassword());
    	System.out.println(user2.getId() + "등록 성공!");
    }
}
