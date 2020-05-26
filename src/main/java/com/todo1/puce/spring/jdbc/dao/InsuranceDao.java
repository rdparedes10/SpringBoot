/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Vehicle;

/**
 * @author rparedes
 *
 */
public class InsuranceDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Vehicle> getListAll() {

		String sql = "select * from vehicle";

		return this.jdbcTemplate.query(sql, new RowMapper<Vehicle>() {
			@Override
			public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
				Vehicle v = new Vehicle();
				v.setChassis(rs.getString("ID"));
				v.setIdBrand(rs.getString("NAME"));
				v.setLicensePlate(rs.getString("PRICE"));
				v.setManufacturingDate(rs.getString("PRICE"));
				return v;
			}
		});
	}

	public Integer totalVehicule() {
		String sql = "select count(*) from vehicle";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Vehicle find(Integer id) {
		String sql = "select * from vehicle where ID = ?";
		return this.jdbcTemplate.queryForObject(sql, new VehicleRowMapper(), id);
	}

	public void insert(Vehicle vehicle) {
		String sql = "insert into vehicle (ID, NAME, PRICE) values (?, ?, ?)";
		this.jdbcTemplate.update(sql, vehicle.getChassis(), vehicle.getIdBrand(), vehicle.getLicensePlate(),
				vehicle.getManufacturingDate());
	}

	public void update(Vehicle vehicle) {
		String sql = "update vehicle set NAME = ?, PRICE = ? where ID = ?";
		this.jdbcTemplate.update(sql, vehicle.getChassis(), vehicle.getIdBrand(), vehicle.getLicensePlate(),
				vehicle.getManufacturingDate());
	}

	public void delete(String chassis) {
		String sql = "delete from vehicle where ID = ?";
		this.jdbcTemplate.update(sql, chassis);
	}

	class VehicleRowMapper implements RowMapper<Vehicle> {

		public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
			Vehicle v = new Vehicle();
			v.setChassis(rs.getString("ID"));
			v.setIdBrand(rs.getString("NAME"));
			v.setLicensePlate(rs.getString("PRICE"));
			v.setManufacturingDate(rs.getString("PRICE"));
			return v;
		}

	}

}
