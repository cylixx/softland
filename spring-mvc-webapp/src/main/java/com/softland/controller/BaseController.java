package com.softland.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softland.dto.User;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("counter", ++counter);
		logger.debug("[welcome] counter : {}", counter);

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;
	}
	
//	@RequestMapping(value = "/user", method = RequestMethod.POST)
//	public String saveOrUpdateUser(@ModelAttribute("userForm") User user, ModelMap model) {
//		logger.debug("saveOrUpdateUser() : {}", user);
//		model.addAttribute("user", user);
//		return "user";
//	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> saveOrUpdateUser2(@RequestBody User user) {
		logger.debug("saveOrUpdateUser() : {}", user);
//		model.addAttribute("user", user);
//		return "user";
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}