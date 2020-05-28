/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Location;

/**
 * @author rparedes
 *
 */
public class LocationDao extends BaseDao {
	private JdbcTemplate jdbcTemplate;

	public LocationDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Location> getListAll() {

		String sql = "select * from ubicacion";

		return this.jdbcTemplate.query(sql, new RowMapper<Location>() {
			@Override
			public Location mapRow(ResultSet rs, int i) throws SQLException {
				Location location = new Location();
				location.setId(rs.getString("idUbicacion"));
				location.setLat(rs.getString("latitud"));
				location.setLon(rs.getString("longitud"));
				location.setCodS(rs.getString("codS"));
				return location;
			}
		});
	}

	public Location find(String id) {
		String sql = "select * from ubicacion where idUbicacion = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new LocationRowMapper(), id);
		} catch (Exception e) {
			return null;
		}

	}

	public void insert(Location location) {

		String sql = "insert into ubicacion (idUbicacion, longitud, latitud, codS) values (?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, location.getId(), location.getLon(), location.getLat(), location.getCodS());
	}

	public void update(Location location) {
		String sql = "update ubicacion set idUbicacion = ?, longitud = ? , latitud = ?, codS = ? where idUbicacion = ?";
		this.jdbcTemplate.update(sql, location.getId(), location.getLon(), location.getLat(), location.getCodS(),
				location.getId());
	}

	public void delete(String id) {
		String sql = "delete from ubicacion where idUbicacion = ?";
		this.jdbcTemplate.update(sql, id);
	}

	class LocationRowMapper implements RowMapper<Location> {

		public Location mapRow(ResultSet rs, int i) throws SQLException {
			Location location = new Location();
			location.setId(rs.getString("idUbicacion"));
			location.setLat(rs.getString("latitud"));
			location.setLon(rs.getString("longitud"));
			location.setCodS(rs.getString("codS"));
			return location;
		}

	}
}
