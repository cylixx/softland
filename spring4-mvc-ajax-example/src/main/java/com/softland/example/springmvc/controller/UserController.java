/*
 @RestController : First of all, we are using Spring 4′s new @RestController annotation. This annotation eliminates the need of annotating each 
                   method with @ResponseBody. Under the hood, @RestController is itself annotated with @ResponseBody, and can be considered as 
                   combination of @Controller and @ResponseBody.
 
 */
package com.softland.example.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// Retrieve Single User
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findById(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
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
