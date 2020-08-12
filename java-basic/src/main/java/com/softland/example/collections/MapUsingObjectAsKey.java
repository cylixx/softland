package com.softland.example.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUsingObjectAsKey {

	public static void main(String[] args) {
		Map<User, User> map = new HashMap<>();
		
		// to be able to use an object as key, you need to override 2 methods in your bean
		// hashCode() and equals()
		
		User u1 = new User(1, "Marco", 1234567890);
		User u2 = new User(2, "Linh", 54522623);
		User u3 = new User(3, "Kumar", 6565655);
		User u4 = new User(2, "Selene", 54522623);
		
		map.put(u1, u1);
		map.put(u2, u2);
		map.put(u3, u3);
		map.put(u4, u4);
		System.out.println(map.size()); 
		System.out.println(map.toString());
		
		System.out.println("Map with key u2: " + map.get(u2));
		
		for (User user: map.keySet()) {
			System.out.printf("%s ", user.name);
		}
	}

}


class User {
	 int id;
	 String name;
	 int phone;
	
	public User(int id, String name, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + phone;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone != other.phone)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[id=%s, name=%s, phone=%s]", id, name, phone);
	}

	
}
