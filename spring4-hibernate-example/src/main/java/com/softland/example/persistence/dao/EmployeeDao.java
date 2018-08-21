package com.softland.example.persistence.dao;

import java.util.List;

import com.softland.example.persistence.model.Employee;

public interface EmployeeDao {

	void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    void deleteEmployeeBySsn(String ssn);
	Employee findBySsn(String ssn);
	void updateEmployee(Employee employee);
}
