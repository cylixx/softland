package com.example.springbootrestexample.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springbootrestexample.repository.PostRepository;
import com.example.springbootrestexample.repository.UserRepository;
import com.example.springbootrestexample.service.UserNotFoundException;
import com.example.springbootrestexample.vo.Post;
import com.example.springbootrestexample.vo.User;

@RestController
@RequestMapping(value="/jpa")
public class UserJPAResource {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@RequestMapping(value="/user", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Resource<User> findOne(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id); 
//		if (user==null) {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
		if (!user.isPresent()) {
			throw new UserNotFoundException("No se encontro usuario con ID: " + id); 
		}
		
		// HATEOAS
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saveUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping("/user/{id}")
	public void dleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	
	//GET all posts
	@GetMapping(value="/user/{id}/posts")
	public List<Post> getAllUsersPosts(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("No se encontro usuario con ID: " + id); 
		}
		 return userOptional.get().getPosts();
	}
	
	//CREATE post
	@PostMapping("/user/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("No se encontro usuario con ID: " + id); 
		}
		
		User user = userOptional.get();
		post.setUser(user);  // asignamos el user que recuperamos de la base
		postRepository.save(post);
		
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	
}
