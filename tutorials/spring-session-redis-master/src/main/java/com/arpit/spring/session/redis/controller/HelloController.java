package com.arpit.spring.session.redis.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.arpit.spring.session.redis.model.Person;

@Controller
@RequestMapping
@SessionAttributes("person")
public class HelloController {

	private static final String PERSON = "person";

	@RequestMapping(value = { "/get" })
	public ModelAndView hello(@RequestBody Person person,
			HttpServletRequest request) {
		//request.getSession().setAttribute(PERSON, person);
		ModelAndView modelAndView = new ModelAndView();
		final Person sessionObject = Optional.ofNullable(request.getSession(false))
				.map(session -> (Person) session.getAttribute(PERSON))
				.orElse(null);
		
		if(sessionObject != null){
			modelAndView.addObject("person", sessionObject);
			modelAndView.setViewName("welcome");
		}else{
			/**
			 * Any object can be added to the @Model in controller and it will
			 * stored in session if its name matches with the argument in @SessionAttributes
			 * annotation.
			 */
			modelAndView.addObject("person", person);
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}
}
