package com.softland.example.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.softland.example.hibernate.HibernateUtil;
import com.softland.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {


	/* Method to CREATE an employee in the database */
	   public Integer addEmployee(String fname, BigDecimal salary, String ssn){
//	      Session session = factory.openSession();
		  Session session = HibernateUtil.getSession();
	      Transaction tx = null;
	      Integer employeeID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = new Employee(fname, new Date(), salary, ssn);
	         employeeID = (Integer) session.save(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return employeeID;
	   }
	   
	   /* Method to  READ all the employees */
	   public void listEmployees( ){
//	      Session session = factory.openSession();
		  Session session = HibernateUtil.getSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
	            Employee employee = (Employee) iterator.next();
	            System.out.println(employee); 
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to UPDATE salary for an employee */
	   public void updateEmployee(Integer employeeID, BigDecimal salary ){
//	      Session session = factory.openSession();
		  Session session = HibernateUtil.getSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, employeeID); 
	         employee.setSalary( salary );
			 session.update(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to DELETE an employee from the records */
	   public void deleteEmployee(Integer employeeID) {
//	      Session session = factory.openSession();
		  Session session = HibernateUtil.getSession(); 
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, employeeID); 
	         session.delete(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }

}
