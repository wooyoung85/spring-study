package com.skcc.toby_spring.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/studydb?useSSL=false&serverTimezone=UTC", "study", "1111");

		return c;
	}

}
