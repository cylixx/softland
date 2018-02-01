package com.softland.example.oop.abstractVSinterface;


/*
 * We normally prefer to use an interface in real time:
 *  when we know what to do but don't know how to do it.
 *  
 *  
 *  Consider using interfaces if :

    1. You expect that unrelated classes would implement your interface. For example,many unrelated objects can implement Serializable interface.
    2. You want to specify the behaviour of a particular data type, but not concerned about who implements its behaviour.
    3. You want to take advantage of multiple inheritance of type.

	In simple terms, I would like to use

	interface: To implement a contract by multiple unrelated objects
 *  
 *  
 *  Reference:
 *  https://stackoverflow.com/questions/761194/interface-vs-abstract-class-general-oo/33963650#33963650
 */
public interface Payment {

	void makePayment();//by default it is a abstract method
	
}
