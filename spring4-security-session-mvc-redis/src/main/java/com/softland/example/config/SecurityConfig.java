/*
 * Copyright 2014-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.softland.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * @author mhinojosa
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//public class SecurityConfig {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/**").hasRole("BASICO").and().formLogin();
//		super.configure(http);
//	}
	
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		//auth.inMemoryAuthentication().withUser(User.withUsername("user").password("{noop}password").roles("USER").build());
//		auth.inMemoryAuthentication().withUser("marquito").password("miclave").roles("USER");
//	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//simply prefix {noop} to your passwords in order for the DelegatingPasswordEncoder use the 
		//NoOpPasswordEncoder to validate these passwords.
		//NoOpPasswordEncoder for inMemoryAuthentication
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
        
        //Encryp password inMemoryAuthentication
//        User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .requestCache()
            .requestCache(new NullRequestCache())
            .and()
            .httpBasic();
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
	
}
