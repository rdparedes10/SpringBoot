/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Brand;

/**
 * @author rparedes
 *
 */
public class BrandDao extends BaseDao {

	private JdbcTemplate jdbcTemplate;

	public BrandDao() {
		this.jdbcTemplate = getJdbcTemplate();
	}

	public List<Brand> getListAll() {

		String sql = "select * from marca";

		return this.jdbcTemplate.query(sql, new RowMapper<Brand>() {
			@Override
			public Brand mapRow(ResultSet rs, int i) throws SQLException {
				Brand b = new Brand();
				b.setIdBrand(rs.getString("idMarca"));
				return b;
			}
		});
	}

	public Integer totalVehicule() {
		String sql = "select count(*) from brand";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public Brand find(String id) {
		String sql = "select * from marca where idMarca = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql, new BrandRowMapper(), id);
		} catch (Exception e) {
			return null;
		}
	}

	public void insert(Brand brand) {
		String sql = "insert into marca (idMarca) values (?)";
		this.jdbcTemplate.update(sql, brand.getIdBrand());
	}

	public void delete(String chassis) {
		String sql = "delete from marca where idMarca = ?";
		this.jdbcTemplate.update(sql, chassis);
	}

	class BrandRowMapper implements RowMapper<Brand> {

		public Brand mapRow(ResultSet rs, int i) throws SQLException {
			Brand b = new Brand();
			b.setIdBrand(rs.getString("idMarca"));
			return b;
		}

	}

}
