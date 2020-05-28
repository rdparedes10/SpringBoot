/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Adviser;

/**
 * @author rparedes
 *
 */
public class AdviserDao  extends BaseDao {
	private JdbcTemplate jdbcTemplate;

	public AdviserDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Adviser> getListAll() {

		String sql = "select * from asesor";

		return this.jdbcTemplate.query(sql, new RowMapper<Adviser>() {
			@Override
			public Adviser mapRow(ResultSet rs, int i) throws SQLException {
				Adviser adviser = new Adviser();
				adviser.setCod(rs.getString("cod"));
				adviser.setName(rs.getString("nombre"));
				adviser.setLastname(rs.getString("apellido"));
				adviser.setPhone(rs.getString("telefono"));
				return adviser;
			}
		});
	}

	public Adviser find(String cod) {
		String sql = "select * from asesor where cod = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new AdviserRowMapper(), cod);
		} catch (Exception e) {
			return null;
		}

	}

	public void insert(Adviser adviser) {

		String sql = "insert into asesor (cod, nombre, apellido, telefono) values (?, ?, ? ,?)";
		this.jdbcTemplate.update(sql, adviser.getCod(), adviser.getName(), adviser.getLastname(), adviser.getPhone());
	}

	public void update(Adviser adviser) {
		String sql = "update asesor set cod = ?, nombre = ? , apellido = ?, telefono = ? where cod = ?";
		this.jdbcTemplate.update(sql, adviser.getCod(), adviser.getName(), adviser.getLastname(), adviser.getPhone(), adviser.getCod());
	}

	public void delete(String cod) {
		String sql = "delete from asesor where cod = ?";
		this.jdbcTemplate.update(sql, cod);
	}

	class AdviserRowMapper implements RowMapper<Adviser> {

		public Adviser mapRow(ResultSet rs, int i) throws SQLException {
			Adviser adviser = new Adviser();
			adviser.setCod(rs.getString("cod"));
			adviser.setName(rs.getString("nombre"));
			adviser.setLastname(rs.getString("apellido"));
			adviser.setPhone(rs.getString("telefono"));
			return adviser;
		}

	}
}
