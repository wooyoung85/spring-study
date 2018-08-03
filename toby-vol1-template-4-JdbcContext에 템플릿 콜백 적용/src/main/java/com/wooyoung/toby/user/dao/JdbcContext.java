package com.wooyoung.toby.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;

		try {
			c = this.dataSource.getConnection();
			ps = stmt.makePreparedStatement(c);
			ps.executeUpdate();
		} catch (SQLException ex) {
			throw ex;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}

			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	// 가변인자(varargs)를 활용하여 PreparedStatement 바인딩 될 파라미터 추가 가능하게 함
	// parameter로 String만 받을 수 있기 때문에 추후 수정 필요
	public void executeSql(final String query, String... params) throws SQLException {
		workWithStatementStrategy(new StatementStrategy() {
			public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
				PreparedStatement ps = c.prepareStatement(query);
				if (params.length > 0) {
					int i = 1;
					for (String param : params) {
						ps.setString(i, param);
						i++;
					}

				}
				return ps;
			}
		});
	}
}
