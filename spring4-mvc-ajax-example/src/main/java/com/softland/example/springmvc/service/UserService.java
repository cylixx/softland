package com.softland.example.springmvc.service;

import java.util.List;

import com.softland.example.springmvc.model.User;

public interface UserService {
	
	void saveUser(User user);
	User findById(long id);
	User findByName(String name);
	List<User> findAllUsers();
	public boolean isUserExist(User user);
	
}
