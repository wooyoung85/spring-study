package com.skcc.toby_spring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.skcc.toby_spring.user.User;
import com.skcc.toby_spring.user.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/applicationContext.xml")
@DirtiesContext
public class SpringJunitUserDaoTest {
	
	@Autowired
	private UserDao dao;
	
	@Before
	public void setup() {
		DataSource dataSource = new SingleConnectionDataSource("jdbc:mysql://localhost:3306/studydbtest?useSSL=false&serverTimezone=UTC", "study", "1111", true);		
		dao.setDataSource(dataSource);
	}
	
	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		dao.deleteAll();

		User user = new User();
		user.setId("user1");
		user.setName("1번 사용자");
		user.setPassword("1111");

		dao.add(user);

		User user2 = dao.get(user.getId());

		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}

	@Test
	public void count() throws SQLException, ClassNotFoundException {
		User user1 = new User("user1", "사용자1", "1111");
		User user2 = new User("user2", "사용자2", "2222");
		User user3 = new User("user3", "사용자3", "3333");

		dao.deleteAll();
		assertThat(dao.getCount(), is(0));

		dao.add(user1);
		assertThat(dao.getCount(), is(1));

		dao.add(user2);
		assertThat(dao.getCount(), is(2));

		dao.add(user3);
		assertThat(dao.getCount(), is(3));
	}

	@Test(expected=EmptyResultDataAccessException.class)
	public void getUserFailure() throws SQLException, ClassNotFoundException{
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.get("unknown_id");
	}
}
