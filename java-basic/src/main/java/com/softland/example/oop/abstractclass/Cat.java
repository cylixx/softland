package com.softland.example.oop.abstractclass;

public class Cat extends Animal {

	@Override
	String eat() {
		return "croquetas";
	}

	@Override
	String howMove() {
		return "camina en cuatro patas";
	}
	
	public String name() {
		return "Gato";
	}

}
