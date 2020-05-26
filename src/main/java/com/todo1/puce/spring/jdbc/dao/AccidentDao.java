/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Accident;

/**
 * @author rparedes
 *
 */
public class AccidentDao extends BaseDao {
	private JdbcTemplate jdbcTemplate;

	public AccidentDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Accident> getListAll() {

		String sql = "select * from siniestro";

		return this.jdbcTemplate.query(sql, new RowMapper<Accident>() {
			@Override
			public Accident mapRow(ResultSet rs, int i) throws SQLException {
				Accident accident = new Accident();
				accident.setCod(rs.getString("cod"));
				accident.setDescription(rs.getString("descripcion"));
				accident.setCodAd(rs.getString("codA"));
				return accident;
			}
		});
	}

	public Accident find(String accident, String pass) {
		String sql = "select * from siniestro where cod = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new AccidentRowMapper(), accident, pass);
		} catch (Exception e) {
			return null;
		}

	}

	public void insert(Accident accident) {

		String sql = "insert into siniestro (cod, descripcion, codA) values (?, ?, ?)";
		this.jdbcTemplate.update(sql, accident.getCod(), accident.getDescription(), accident.getCodAd());
	}

	public void update(Accident accident) {
		String sql = "update siniestro set cod = ?, descripcion = ? , codA = ? where cod = ?";
		this.jdbcTemplate.update(sql, accident.getCod(), accident.getDescription(), accident.getCodAd(),
				accident.getCod());
	}

	public void delete(String cod) {
		String sql = "delete from siniestro where cod = ?";
		this.jdbcTemplate.update(sql, cod);
	}

	class AccidentRowMapper implements RowMapper<Accident> {

		public Accident mapRow(ResultSet rs, int i) throws SQLException {
			Accident accident = new Accident();
			accident.setCod(rs.getString("cod"));
			accident.setDescription(rs.getString("accident"));
			accident.setCodAd(rs.getString("codA"));
			return accident;
		}

	}
}