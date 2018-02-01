package com.softland.example.oop.abstractVSinterface;

/*
 * We choose an abstract class:
 *  when there are some features for which we know what to do, and other features that we know how to perform.
 *  
 *  
 *  Consider using abstract classes if :

    1. You want to share code among several closely related classes.
    2. You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
    3. You want to declare non-static or non-final fields.

	In simple terms, I would like to use

	abstract class: To implement the same or different behaviour among multiple related objects 
 *  
 */
public abstract class Burger {
	
	public void packing() {
		// some logic for packing a burger
	}

	public abstract void price(); // price is different for different categories of burgers
}
