package com.softland.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.softland.example.repositories.UsersRepository;

@Controller
public class HelloMongoController {

	@Autowired
	private UsersRepository repository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView helloWorld(ModelMap model) {

		List users = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("users", users);
		return modelAndView;
	}

}
