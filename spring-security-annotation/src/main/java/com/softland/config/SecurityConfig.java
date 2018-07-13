package com.softland.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/* 
   4. Create a Spring Security configuration file, and annotated with @EnableWebSecurity

	The equivalent of the Spring Security xml file :

	<http auto-config="true">
		<intercept-url pattern="/admin**" access="ROLE_ADMIN" />
		<intercept-url pattern="/dba**" access="ROLE_ADMIN,ROLE_DBA" />
	</http>
	
	<authentication-manager>
	  <authentication-provider>
	    <user-service>
		<user name="cylixx" password="123456" authorities="ROLE_USER" />
		<user name="admin" password="123456" authorities="ROLE_ADMIN" />
		<user name="dba" password="123456" authorities="ROLE_DBA" />
	    </user-service>
	  </authentication-provider>
	</authentication-manager>
 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("cylixx").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();
//		http.authorizeRequests()
//		.antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/dba**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();

	}
}