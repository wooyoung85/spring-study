package com.skcc.toby_spring;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.skcc.toby_spring.user.User;
import com.skcc.toby_spring.user.dao.ConfigDaoFactory;
import com.skcc.toby_spring.user.dao.UserDao;

public class UserDaoTest 
{
    @SuppressWarnings("resource")
	public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ConfigDaoFactory.class);    	
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
    	System.out.println(user2.getId() + "조회 성공!");
    }
}
