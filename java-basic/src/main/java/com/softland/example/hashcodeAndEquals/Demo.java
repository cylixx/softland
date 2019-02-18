package com.softland.example.hashcodeAndEquals;

import java.util.HashMap;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {

		Employee emp1 = new Employee(1);
		Employee emp2 = new Employee(1);
		
		Map<Employee, String> map = new HashMap<Employee, String>(); 
		map.put(emp1, "Marco");
		map.put(emp2, "Marco");
		
		System.out.println(map.size());  // guess it 2
		System.out.println(map.toString());
		// what you need to do to make this map return 1?
		// R. with the hashCode and equal method
		
		//clue
		Integer i = new Integer(1);
		Integer i1 =  new Integer(1);
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		map1.put(i1, "one");
		map1.put(i1, "one");
		
		System.out.println(map1.size()); //guess it 1
		System.out.println(map1.toString());
		
	}

}

class Employee {
	int id;
	
	public Employee (int id) {
		this.id = id;
	}
 
	// this method is necessary for identify and object throw fields
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	// to compare objects
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
