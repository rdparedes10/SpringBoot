/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Vehicle;

/**
 * @author rparedes
 *
 */
public class VehicleDao extends BaseDao {

	private JdbcTemplate jdbcTemplate;

	public VehicleDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Vehicle> getListAll() {

		String sql = "select * from vehiculo";

		return this.jdbcTemplate.query(sql, new RowMapper<Vehicle>() {
			@Override
			public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
				Vehicle v = new Vehicle();
				v.setLicensePlate(rs.getString("placa"));
				v.setChassis(rs.getString("chasis"));
				v.setManufacturingDate(rs.getString("fecha_fabricacion"));
				v.setIdBrand(rs.getString("idMarca"));
				v.setPhoto(rs.getString("foto"));
				v.setIdClient(rs.getString("cedulaC"));
				v.setModel(rs.getString("modelo"));
				return v;
			}
		});
	}

	public Integer totalVehicule() {
		String sql = "select count(*) from vehiculo";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Vehicle find(String id) {
		String sql = "select * from vehiculo where placa = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new VehicleRowMapper(), id);
		} catch (Exception e) {
			return null;
		}
		
	}

	public void insert(Vehicle vehicle) {
		String sql = "insert into vehiculo (placa, chasis, fecha_fabricacion, idMarca, foto, cedulaC, modelo) values (?, ?, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, vehicle.getLicensePlate(), vehicle.getChassis(), vehicle.getManufacturingDate(),
				vehicle.getIdBrand(), vehicle.getPhoto(), vehicle.getIdClient(), vehicle.getModel());
	}

	public void update(Vehicle vehicle) {
		String sql = "update vehiculo set placa = ?, chasis = ?, fecha_fabricacion = ?, idMarca = ?, foto = ?, cedulaC = ?, modelo = ? where placa = ?";
		this.jdbcTemplate.update(sql, vehicle.getLicensePlate(), vehicle.getChassis(), vehicle.getManufacturingDate(),
				vehicle.getIdBrand(), vehicle.getPhoto(), vehicle.getIdClient(), vehicle.getModel(), vehicle.getLicensePlate());
	}

	public void delete(String chassis) {
		String sql = "delete from vehiculo where placa = ?";
		this.jdbcTemplate.update(sql, chassis);
	}

	class VehicleRowMapper implements RowMapper<Vehicle> {

		public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
			Vehicle v = new Vehicle();
			v.setLicensePlate(rs.getString("placa"));
			v.setChassis(rs.getString("chasis"));
			v.setManufacturingDate(rs.getString("fecha_fabricacion"));
			v.setIdBrand(rs.getString("idMarca"));
			v.setPhoto(rs.getString("foto"));
			v.setIdClient(rs.getString("cedulaC"));
			v.setModel(rs.getString("modelo"));
			return v;
		}

	}

}
