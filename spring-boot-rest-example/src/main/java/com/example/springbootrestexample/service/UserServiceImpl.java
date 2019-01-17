package com.example.springbootrestexample.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootrestexample.vo.User;

@Service
public class UserServiceImpl implements UserService{

//	private static List<User> users;
//	static {
//		users = dummyDataUser();
//	}
//	private static final List<User> users = dummyDataUser();
	private static List<User> users = new ArrayList<User>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1, "Marco", new Date()));
		users.add(new User(2, "Rosita", new Date()));
		users.add(new User(3, "Selene", new Date()));
	}
	
	
	@Override
	public List<User> gettAll() {
		return users;
	}
	
	
	@Override
	public User save(User user) { 
		if (user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	
	@Override
	public User findOne(int id) {
		return users.stream().filter(
				//x -> name.equals(x.getName())
				x -> id == x.getId()
				).findAny()
				.orElse(null);
	}
	

	
//	private static List<User> dummyDataUser() {
//		List<User> users = new ArrayList<User>();
//		users.add(new User("Marco", 35));
//		users.add(new User("Selene", 33));
//		users.add(new User("Rosa", 50));
//		users.add(new User("Beto", 45));
//		users.add(new User("Alexis", 26));
//		return users;
//	}
	
}
