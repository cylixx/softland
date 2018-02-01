package com.softland.example.oop.abstractclass;

public class Bird extends Animal {

	@Override
	String eat() {
		return "alpiste";
	}

	@Override
	String howMove() {
		return "vuela";
	}

	public String name() {
		return "Pajaro";
	}
	
}
