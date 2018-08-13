/*
  
@EnableWebMvc annotation is used to enable Spring MVC.

@Configuration annotation imports the Spring configuration. @Configuration objects are managed as Spring beans within the container, 
               imported configurations are used to injected using @Autowired or @Inject.

@ComponentScan is equivalent to <context:component-scan base-package="..." used to lookup the beans and components classes in the spring context.

Configure static resources handlers - Add handlers to serve static resources such as images, js and css files from specific locations.

Override addResourceHandlers(ResourceHandlerRegistry registry) method. This handlers used to serve static resources such as images, js, 
          and css files from specific locations.

addResourceHandler() - Add a resource handler for serving static resources based on the specified URL path patterns.

addResourceLocations() - Add one or more resource locations from which to serve static content. 
						 Each location must point to a valid directory. Multiple locations may be specified as a comma-separated list, 
						 and the locations will be checked for a given resource in the order specified.

 */
package com.softland.example.springmvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.softland.example.springmvc" })
public class AppConfiguration extends WebMvcConfigurerAdapter {

	// To Serve Static Resources with Spring (important extend from WebMvcConfigurerAdapter) 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/jsp/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
	
}
