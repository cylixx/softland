package com.softland.example.mutableVSimmutable;

// OBJETOS MUTABLES
// los objetos mutables son los que pueden cambiar su estado
public class MutableClass {
	private int value;

	public MutableClass(int aValue) {
		value = aValue;
	}

	//aqui cambia el estado de la variable
	public void setValue(int aValue) {
		value = aValue;
	}

	public int getValue() {
	  return value;
	 }
	
	// metodo para cambiar el valor de la propiedad value
	public void changeValue() {
		this.value++;
	}

	@Override
	public String toString() {
		return "MutableClass [value=" + value + "]";
	}

}
