package com.wooyoung.toby.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.wooyoung.toby.user.domain.User;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<User> userMapper = new RowMapper<User>() {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("password"));

			return user;
		}
	};

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void add(final User user) throws SQLException {
		jdbcTemplate.update("insert into users(id, name, password) values(?,?,?)", user.getId(), user.getName(),
				user.getPassword());
	}

	public void deleteAll() {
		this.jdbcTemplate.update("delete from users");
	}

	public User get(String id) throws SQLException {
		
		return jdbcTemplate.queryForObject("select * from users where id = ?", new Object[] { id }, userMapper);
	}

	public int getCount() throws SQLException {
		return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	}

	public List<User> getAll() {
		return jdbcTemplate.query("select * from users", userMapper);
	}
}
