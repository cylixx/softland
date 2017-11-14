package com.softland.example.mutableVSimmutable;

// OBJETOS INMUTABLES
// No cambian una ves que son instanciados, 
// se convierten en objetos de solo lectura luego de la instanciación

// los objetos inmutables son ideales para representar números 
// ( como java.lang.Integer, java.lang.Float, java.lang.BigDecimal etc ) , 
// enumerated types, colores (java.awt.Color)

// Beneficios
// Las clases inmutables son intrínsecamente Thread-safe y por este motivo 
// no hace falta sincronizar el acceso a ellos cuando se utilizan dentro 
// de un ambiente multi-hilo.
public class ImmutableClass {
	
	// final - cumple dos roles
	// 1. Forzar que se inicialize el campo una sola vez en la clase
	//    y que no se le pueda cambiar el valor
	// 2. Fuerza que el campo se inicie en el constructor de la clase
	private final int value;

	public ImmutableClass(final int aValue) {
		// The value is set. Now, and forever.
		value = aValue;
	}

	public final int getValue() {
		return value;
	}
	
	// metodo para cambiar el valor de la propiedad value
	public void changeValue() {
		System.out.println("Dentro de changeValue(), pero no cambio nada...");
	}

	@Override
	public String toString() {
		return "MutableClass [value=" + value + "]";
	}
}
