package com.softland.example.service;

import java.math.BigDecimal;

public interface EmployeeService {

	public Integer addEmployee(String fname, BigDecimal salary, String ssn);
	public void listEmployees( );
	public void updateEmployee(Integer employeeID, BigDecimal salary);
	public void deleteEmployee(Integer employeeID);
}
