/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.todo1.puce.spring.jdbc.model.User;

/**
 * @author rparedes
 *
 */
@Repository
public class UserDao extends BaseDao {

	private JdbcTemplate jdbcTemplate;

	public UserDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<User> getListAll() {

		String sql = "select * from usuario";

		return this.jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int i) throws SQLException {
				User user = new User();
				user.setCedula(rs.getString("cedula"));
				user.setUser(rs.getString("user"));
				user.setEmail(rs.getString("email"));
				user.setPass(rs.getString("pass"));
				return user;
			}
		});
	}

	public User find(String user, String pass) {
		String sql = "select * from usuario where user = ? and pass = ? ";
		try {
			return this.jdbcTemplate.queryForObject(sql, new UserRowMapper(), user, pass);
		} catch (Exception e) {
			return null;
		}
		
	}

	class UserRowMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int i) throws SQLException {
			User user = new User();
			user.setCedula(rs.getString("cedula"));
			user.setUser(rs.getString("user"));
			user.setEmail(rs.getString("email"));
			user.setPass(rs.getString("pass"));
			return user;
		}

	}
}
