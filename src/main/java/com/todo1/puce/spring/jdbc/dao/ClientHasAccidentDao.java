/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.ClientHasAccident;

/**
 * @author rparedes
 *
 */
public class ClientHasAccidentDao extends BaseDao {
	private JdbcTemplate jdbcTemplate;

	public ClientHasAccidentDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<ClientHasAccident> getListAll() {

		String sql = "select * from cliente_has_siniestro";

		return this.jdbcTemplate.query(sql, new RowMapper<ClientHasAccident>() {
			@Override
			public ClientHasAccident mapRow(ResultSet rs, int i) throws SQLException {
				ClientHasAccident clientHasAccident = new ClientHasAccident();
				clientHasAccident.setCod(rs.getString("codS"));
				clientHasAccident.setId(rs.getString("cedula"));
				return clientHasAccident;
			}
		});
	}

	public ClientHasAccident find(String cod) {
		String sql = "select * from cliente_has_siniestro where cod = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new ClientHasAccidentRowMapper(), cod);
		} catch (Exception e) {
			return null;
		}

	}

	public void insert(ClientHasAccident clientHasAccident) {

		String sql = "insert into cliente_has_siniestro (cedula, codS) values (?, ?)";
		this.jdbcTemplate.update(sql, clientHasAccident.getId(), clientHasAccident.getCod());
	}

	public void update(ClientHasAccident clientHasAccident) {
		String sql = "update cliente_has_siniestro set cedula = ?, codS = ?  where cedula = ? and codS = ?";
		this.jdbcTemplate.update(sql, clientHasAccident.getId(), clientHasAccident.getCod(), clientHasAccident.getId(), clientHasAccident.getCod());
	}

	public void delete(String cod) {
		String sql = "delete from cliente_has_siniestro where cod = ?";
		this.jdbcTemplate.update(sql, cod);
	}

	class ClientHasAccidentRowMapper implements RowMapper<ClientHasAccident> {

		public ClientHasAccident mapRow(ResultSet rs, int i) throws SQLException {
			ClientHasAccident clientHasAccident = new ClientHasAccident();
			clientHasAccident.setCod(rs.getString("codS"));
			clientHasAccident.setId(rs.getString("cedula"));
			return clientHasAccident;
		}

	}
}