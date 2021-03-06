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
public class VehicleAndClienteDataDao extends BaseDao{
	
	private JdbcTemplate jdbcTemplate;

	public VehicleAndClienteDataDao() {
		this.jdbcTemplate = getJdbcTemplate();
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

}
