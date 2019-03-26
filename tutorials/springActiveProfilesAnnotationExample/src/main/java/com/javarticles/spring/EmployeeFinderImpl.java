package com.javarticles.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeFinderImpl implements EmployeeFinder {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee findEmployeeByName(String name) {
        System.out.println("Find emp from db");
        return jdbcTemplate.query("select * from employee where name = ?", new EmployeeExtractor(), name);
    }
}
