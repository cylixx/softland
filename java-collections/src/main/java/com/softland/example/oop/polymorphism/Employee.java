package com.softland.example.oop.polymorphism;

public class Employee {
	protected Integer Id;

	public Employee() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	public  String getTitle() {
		return "Employee general";
	}
}
