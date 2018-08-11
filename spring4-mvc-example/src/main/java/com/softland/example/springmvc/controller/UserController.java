package com.softland.example.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.softland.example.springmvc.model.User;

import com.softland.example.springmvc.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	// Retrive All Users
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// Save user
	@RequestMapping(value = "/user/", method = RequestMethod.POST )
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating user " + user.getName());
		
		if (userService.isUserExist(user)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		userService.saveUser(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri()); // setea header con URL para buscar por ID
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	
}
