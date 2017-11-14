package com.softland.example;

import org.junit.Test;

import com.softland.example.mutableVSimmutable.ImmutableClass;
import com.softland.example.mutableVSimmutable.MutableClass;

public class MutableVSInmutableTest {

	@Test
	public void testMutableVSinmutable() {
		System.out.println("==================[Mutable object test]=========================");
		MutableClass m = new MutableClass(10);
		System.out.println("Instanciamos clase mutable: ");
		System.out.println( m );
		m.changeValue();
		System.out.println("Resultado despues de invocar metodo changeValue(): ");
		System.out.println( m );
		
		System.out.println("==================[Immutable object test]=========================");
		ImmutableClass im = new ImmutableClass(10);
		System.out.println("Instanciamos clase Immutable: ");
		System.out.println( im );
		im.changeValue();
		System.out.println("Resultado despues de invocar metodo changeValue(): ");
		System.out.println( im );
	}
	
}
