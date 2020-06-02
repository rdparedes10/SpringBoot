/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Insurance;

/**
 * @author rparedes
 *
 */
public class InsuranceDao extends BaseDao {

	private JdbcTemplate jdbcTemplate;

	public InsuranceDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Insurance> getListAll() {

		String sql = "select * from seguro";

		return this.jdbcTemplate.query(sql, new RowMapper<Insurance>() {
			@Override
			public Insurance mapRow(ResultSet rs, int i) throws SQLException {
				Insurance insurance = new Insurance();
				insurance.setIdInsurance(rs.getString("idSeguro"));
				insurance.setCoverageType(rs.getString("tipo_cobertura"));
				insurance.setState(rs.getString("estado"));
				insurance.setType(rs.getString("tipo"));
				return insurance;
			}
		});
	}
	
	public List<Insurance> getListType() {

		String sql = "select * from seguro";

		return this.jdbcTemplate.query(sql, new RowMapper<Insurance>() {
			@Override
			public Insurance mapRow(ResultSet rs, int i) throws SQLException {
				Insurance insurance = new Insurance();
				insurance.setIdInsurance(rs.getString("idSeguro"));
				insurance.setType(rs.getString("tipo"));
				insurance.setCoverageType("");
				insurance.setState("");
				return insurance;
			}
		});
	}

	public Integer totalVehicule() {
		String sql = "select count(*) from seguro";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Insurance find(String id) {
		String sql = "select * from seguro where idSeguro = ?";
		return this.jdbcTemplate.queryForObject(sql, new InsuranceRowMapper(), id);
	}

	public void insert(Insurance insurance) {
		String sql = "insert into seguro (idSeguro, tipo_cobertura, estado, tipo) values (?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, insurance.getIdInsurance(), insurance.getCoverageType(), insurance.getState(), insurance.getType());
	}

	public void update(Insurance insurance) {
		String sql = "update seguro set tipo_cobertura = ?, estado = ?, tipo = ? where idSeguro = ?";
		this.jdbcTemplate.update(sql, insurance.getCoverageType(), insurance.getState(), insurance.getType(), insurance.getIdInsurance());
	}

	public void delete(String id) {
		String sql = "delete from seguro where ID = ?";
		this.jdbcTemplate.update(sql, id);
	}

	class InsuranceRowMapper implements RowMapper<Insurance> {

		public Insurance mapRow(ResultSet rs, int i) throws SQLException {
			Insurance insurance = new Insurance();
			insurance.setIdInsurance(rs.getString("idSeguro"));
			insurance.setCoverageType(rs.getString("tipo_cobertura"));
			insurance.setState(rs.getString("estado"));
			insurance.setType(rs.getString("tipo"));
			return insurance;
		}

	}

}
