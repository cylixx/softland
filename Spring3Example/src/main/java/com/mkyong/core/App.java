package com.mkyong.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.customer.bo.CustomerBo;
import com.mkyong.customer.bo.SomeOtherBo;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

		CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		//customer.addCustomer();
		
		//customer.addCustomerReturnValue();
		
		//customer.addCustomerThrowException();
		
		customer.addCustomerAround("mkyong");

		System.out.println("=============================");
		SomeOtherBo someOther = (SomeOtherBo) appContext.getBean("someOtherBo");
		System.out.println("llamada al metodo someMethod: " + someOther.someMethod("Julia"));
		
	}
}