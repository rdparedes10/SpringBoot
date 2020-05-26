/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.todo1.puce.spring.jdbc.SpringConfiguration;

/**
 * @author rparedes
 *
 */
public class BaseDao {

	private JdbcTemplate jdbcTemplate;

	/**
	 * @return the jdbcTemplate
	 */
	public JdbcTemplate getJdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(SpringConfiguration.dataSource());
		return jdbcTemplate;
	}

}
