package com.example.springbootrestexample.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@Autowired
	private MessageSource messageSource;
	
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
			throw new UserNotFoundException("No se encontro usuario con ID: " + id); 
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
	
	//Internaxionalizacion de mensajes
	@GetMapping(path="/hello-world-i18n", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String helloWorldI18n() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
	
	//================ 40. Step 27 - Versioning RESTful  Services ==============================================
	//VERSIONING PARAM   (Most used and easy for lest knowledge)
	@RequestMapping(value="/user/param", method=RequestMethod.GET, params="version=1")
	public String paramV1() {
		return "VISA";
	}
	@RequestMapping(value="/user/param", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, params="version=2")
	public ResponseEntity<Object> paramV2() {
		Map<String, String> map =  new HashMap<String, String>();
		map.put("typeCard", "MASTER CARD");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	//VERSIONING HEADERS
	@RequestMapping(value="/user/header", method=RequestMethod.GET, headers="X-API-VERSION=1")
	public String headerV1() {
		return "VISA";
	}
	@RequestMapping(value="/user/header", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, headers="X-API-VERSION=2")
	public ResponseEntity<Object> headerV2() {
		Map<String, String> map =  new HashMap<String, String>();
		map.put("typeCard", "MASTER CARD");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	//VERSIONIG PRODUCES
	@RequestMapping(value="/user/produces", method=RequestMethod.GET, produces="application/vnd.company.app-v1+text")
	public String producesV1() {
		return "VISA";
	}
	@RequestMapping(value="/user/produces", method=RequestMethod.GET, produces="application/vnd.company.app-v2+json")
	public ResponseEntity<Object> producesV2() {
		Map<String, String> map =  new HashMap<String, String>();
		map.put("typeCard", "MASTER CARD");
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
}
