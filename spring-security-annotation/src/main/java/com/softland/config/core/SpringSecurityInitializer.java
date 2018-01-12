package com.softland.config.core;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/* 
   1. Create a Class extends AbstractSecurityWebApplicationInitializer, it will load the springSecurityFilterChain automatically.
   
   The equivalent of Spring Security in web.xml file :
   
    <filter>
	   <filter-name>springSecurityFilterChain</filter-name>
	   <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
     </filter>

	<filter-mapping>
		<filter-name>springSecurityFilterChain</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
    
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
   //do nothing
}