package com.softland.example.persistence.service;

import java.util.List;

import com.softland.example.persistence.model.Employee;

public interface EmployeeService {
	
	void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    void deleteEmployeeBySsn(String ssn);
	Employee findBySsn(String ssn);
	void updateEmployee(Employee employee);
}
