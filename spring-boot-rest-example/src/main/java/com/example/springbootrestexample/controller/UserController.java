package com.example.springbootrestexample.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootrestexample.service.UserNotFoundException;
import com.example.springbootrestexample.service.UserService;
import com.example.springbootrestexample.vo.User;

@RestController
//@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String getHello() {
		return "Regards from controller!";
	}
	
	@RequestMapping(value="/user", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.gettAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> findOne(@PathVariable("id") Integer id) {
		User user = userService.findOne(id);
//		if (user==null) {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
		if (user==null) {
			throw new UserNotFoundException("id-"+id); 
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saveUser = userService.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
	
}
