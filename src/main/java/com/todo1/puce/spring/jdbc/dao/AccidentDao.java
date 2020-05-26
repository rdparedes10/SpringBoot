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

import com.todo1.puce.spring.jdbc.model.Accident;

/**
 * @author rparedes
 *
 */
public class AccidentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Accident> getListAll() {

        String sql = "select * from accident";

        return this.jdbcTemplate.query(sql, new RowMapper<Accident>() {
            @Override
            public Accident mapRow(ResultSet rs, int i) throws SQLException {
                Accident a = new Accident();
                a.setCod(rs.getString("ID"));
                a.setCodAd(rs.getString("NAME"));
                a.setDescription(rs.getString("PRICE"));
                return a;
            }
        });
    }

    public Integer totalVehicule() {
        String sql = "select count(*) from accident";
        return this.jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public Accident find(Integer id) {
        String sql = "select * from accident where ID = ?";
        return this.jdbcTemplate.queryForObject(sql, new AccidentRowMapper(), id);
    }

    public void insert(Accident accident) {
        String sql = "insert into accident (ID, NAME, PRICE) values (?, ?, ?)";
        this.jdbcTemplate.update(sql,
                accident.getCod(),
                accident.getCodAd(),
                accident.getDescription());
    }

    public void update(Accident accident) {
        String sql = "update accident set NAME = ?, PRICE = ? where ID = ?";
        this.jdbcTemplate.update(sql,
        		accident.getCod(),
                accident.getCodAd(),
                accident.getDescription());
    }

    public void delete(String chassis) {
        String sql = "delete from accident where ID = ?";
        this.jdbcTemplate.update(sql, chassis);
    }

    class AccidentRowMapper implements RowMapper<Accident> {

        public Accident mapRow(ResultSet rs, int i) throws SQLException {
            Accident v = new Accident();
            v.setCod(rs.getString("ID"));
            v.setCodAd(rs.getString("NAME"));
            v.setDescription(rs.getString("PRICE"));           
            return v;
        }

    }

}