package com.softland.example.oop.polymorphism;

/*
  Polimorfismo
  En Java una variable o nombre usado para referirse a un objeto de una clase X puede usarse para referirse a cualquier objeto de cualquier subclase de la clase X.

 */
public class AppExecute {

	public static void main(String[] args) {

		Employee e = new Employee();
		System.out.println(e.getTitle());
		
		// a esto se le llama Polimorfismo
		e = new Manager();
		System.out.println(e.getTitle());
		
		// a esto se le llama Polimorfismo
		e = new Programmer();
		System.out.println(e.getTitle());
		

     // El inverso no es válido. No se puede asignar una instancia de la superclase a un nombre para la subclase.
	 //	Programmer p = new Employee();
	
		// si queremos obtener la referencia de la subclase (no de la superclase) se necesita hacer un cast a la clase que queramos
		if (e instanceof Manager) {
			Manager manager = (Manager) e;
			System.out.println(manager.getTasks());
			
		} else	if (e instanceof Programmer) {
			Programmer programmer = (Programmer) e;
			System.out.println(programmer.getTasks());
		} 
		
	}

}
