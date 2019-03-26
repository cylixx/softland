package com.softland.example.designpatterns.builder;

public class UserMain {

	public static void main(String[] args) {
		System.out.println("User = " + getUser().toString());
		
	}

	static User getUser() {
		  return new
		    User.UserBuilder("Jhon", "Doe")
		    .age(30)
		    .phone("1234567")
		    .address("Fake address 1234")
		    .build();
	}
}
