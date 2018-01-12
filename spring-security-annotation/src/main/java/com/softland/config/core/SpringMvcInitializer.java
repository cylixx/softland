package com.softland.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.softland.config.AppConfig;

/* 
  2. Create a Initializer class, to load everything.
  
  Note:
	In Servlet 3.x container environment + Spring container will detect and loads the Initializer classes automatically.
	 
 */
public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}