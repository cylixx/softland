package com.softland.example;

import java.math.BigDecimal;

import com.softland.example.service.EmployeeService;
import com.softland.example.service.EmployeeServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		
		EmployeeService employeeService = new EmployeeServiceImpl();

		/* Add few employee records in database */
		Integer empID1 = employeeService.addEmployee("Zara", new BigDecimal(16200.50), "MEX123");
		Integer empID2 = employeeService.addEmployee("Daisy", new BigDecimal(21453.10), "H123455");
		Integer empID3 = employeeService.addEmployee("John", new BigDecimal(17773), "H5465656");

		/* List down all the employees */
		employeeService.listEmployees();

		/* Update employee's records */
		employeeService.updateEmployee(empID1, new BigDecimal(5000));

		/* Delete an employee from the database */
		employeeService.deleteEmployee(empID2);

		/* List down new list of the employees */
		employeeService.listEmployees();
	}

}
