package com.todo1.puce.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class SpringConfiguration {

    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("todo1dev");
        return dataSource;
    }
}
