package com.example.springbootrestexample.service;

import java.util.List;

import com.example.springbootrestexample.vo.User;

public interface UserService {
	public User getUser(String name);
	public List<User> gettAll();
}
