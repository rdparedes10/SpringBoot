/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Client;

/**
 * @author rparedes
 *
 */
public class ClientDao extends BaseDao {

	private JdbcTemplate jdbcTemplate;

	public ClientDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Client> getListAll() {

		String sql = "select * from cliente";

		return this.jdbcTemplate.query(sql, new RowMapper<Client>() {
			@Override
			public Client mapRow(ResultSet rs, int i) throws SQLException {
				Client client = new Client();
				client.setAddress(rs.getString("direccion"));
				client.setPhone(rs.getString("telefono"));
				client.setIdInsurance(rs.getString("idSeguro"));
				client.setName(rs.getString("nombre"));
				client.setLastname(rs.getString("apellido"));
				client.setId(rs.getString("cedula"));
				return client;
			}
		});
	}

	public Client find(String id) {
		String sql = "select * from cliente where cedula = ? ";
		try {
			return this.jdbcTemplate.queryForObject(sql, new ClientRowMapper(), id);
		} catch (Exception e) {
			return null;
		}

	}

	public void insert(Client client) {

		String sql = "insert into cliente (cedula, nombre, apellido, direccion, telefono, idSeguro) values (?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, client.getId(), client.getName(), client.getLastname(), client.getAddress(),
				client.getPhone(), client.getIdInsurance());
	}

	public void update(Client client) {
		String sql = "update cliente set cedula = ?, nombre = ? , apellido = ?, direccion = ? , telefono = ? , idSeguro= ?  where cedula = ?";
		this.jdbcTemplate.update(sql, client.getId(), client.getName(), client.getLastname(), client.getAddress(),
				client.getPhone(), client.getIdInsurance(), client.getId());
	}

	public void delete(String cedula) {
		String sql = "delete from cliente where cedula = ?";
		this.jdbcTemplate.update(sql, cedula);
	}

	class ClientRowMapper implements RowMapper<Client> {

		public Client mapRow(ResultSet rs, int i) throws SQLException {
			Client client = new Client();
			client.setAddress(rs.getString("direccion"));
			client.setPhone(rs.getString("telefono"));
			client.setIdInsurance(rs.getString("idSeguro"));
			client.setName(rs.getString("nombre"));
			client.setLastname(rs.getString("apellido"));
			client.setId(rs.getString("cedula"));
			return client;
		}

	}

}
