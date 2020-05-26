/**
 * 
 */
package com.todo1.puce.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.todo1.puce.spring.jdbc.model.Session;

/**
 * @author rparedes
 *
 */
public class SessionDao extends BaseDao {

    private JdbcTemplate jdbcTemplate;
    
    public SessionDao(){
    	this.jdbcTemplate = getJdbcTemplate();
    }

    public List<Session> getListAll() {

        String sql = "select * from sesion";

        return this.jdbcTemplate.query(sql, new RowMapper<Session>() {
            @Override
            public Session mapRow(ResultSet rs, int i) throws SQLException {
                Session s = new Session();
                s.setSessionId(rs.getString("ID"));
                return s;
            }
        });
    }

  
    public Session find(String id) {
        String sql = "select * from sesion where idSesion = ?";
        return this.jdbcTemplate.queryForObject(sql, new SessionRowMapper(), id);
    }

    public void insert(Session session) {
        String sql = "insert into sesion (idSesion, userName) values (?, ?)";
        this.jdbcTemplate.update(sql, session.getSessionId(), session.getUserName());
    }
    
    public void update(Session session) {
		String sql = "update vehicle set idSesion = ?, userName = ? where idSesion = ?";
		this.jdbcTemplate.update(sql, session.getSessionId(), session.getUserName(), session.getSessionId());
	}

    public void delete(String sessionId) {
        String sql = "delete from sesion where idSesion = ?";
        this.jdbcTemplate.update(sql, sessionId);
    }

    class SessionRowMapper implements RowMapper<Session> {

        public Session mapRow(ResultSet rs, int i) throws SQLException {
            Session s = new Session();
            s.setSessionId(rs.getString("idSesion"));
            s.setUserName(rs.getString("userName"));
            return s;
        }

    }

}