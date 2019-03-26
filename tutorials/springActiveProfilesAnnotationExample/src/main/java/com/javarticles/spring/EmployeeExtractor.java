package com.javarticles.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeExtractor implements ResultSetExtractor<Employee> {

    public Employee extractData(ResultSet rs) throws SQLException,
            DataAccessException {
        rs.next();
        Employee employee = new Employee();
        employee.setName(rs.getString("name"));
        return employee;
    }
}