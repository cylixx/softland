package com.example.springbootrestexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootrestexample.vo.User;

@Service
public class UserServiceImpl implements UserService{

//	private static List<User> users;
//	static {
//		users = dummyDataUser();
//	}
	private static final List<User> users = dummyDataUser();
	
	@Override
	public User getUser(String name) {
		return users.stream().filter(
				x -> name.equals(x.getName())
				).findAny()
				.orElse(null);
	}
	
	@Override
	public List<User> gettAll() {
		return users;
	}

	
	private static List<User> dummyDataUser() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Marco", 35));
		users.add(new User("Selene", 33));
		users.add(new User("Rosa", 50));
		users.add(new User("Beto", 45));
		users.add(new User("Alexis", 26));
		return users;
	}
	
}
