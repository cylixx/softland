package com.example.springbootrestexample.service;

import java.util.List;

import com.example.springbootrestexample.vo.User;

public interface UserService {
	public List<User> gettAll();
	public User save(User user);
	public User findOne(int id);
	
}
