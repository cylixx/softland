package com.actinver.eactinver.management.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("password")
            .roles("USER");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//            .anyRequest().authenticated()
//            .and()
//            .requestCache()
//            .requestCache(new NullRequestCache())
//            .and()
//            .httpBasic();
//    }
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//		 http
//         .authorizeRequests()
//             .antMatchers(
//            		 "/*.html",  //add new
//                     "/*.ico",
//                     "/fonts/**",
//                     "/img/**",
//                     "/pattern-library/**",
//                     "/libs/libs.js",
//                     "/login-modules/login.js",
//                     "/main-modules/**",
//                     "/conf/en.json",
//                     "/css/**").permitAll() 
//             //.anyRequest().hasRole("FRONT_USER")
//             .anyRequest().hasRole("USER")
//         .and()  
//	         .formLogin()
//	             .loginPage("/login")
//	             .usernameParameter("username")
//	             .passwordParameter("password")
//	             .failureUrl("/login/error")
//	//             .failureHandler(authenticationFailureHandler())
//	//             .successHandler(authenticationSuccessHandler())
//	             .permitAll()
//          .and()
//         .logout().permitAll().invalidateHttpSession(true)
//             .logoutUrl("/logout")
////             .logoutSuccessHandler(logoutSuccessHandler())
//         ;
//    }
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
          .authorizeRequests()
          .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
          .antMatchers("/login").permitAll()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }
    
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true); // you USUALLY want this
//        config.addAllowedOrigin("https://www.actinver.com");
//        //config.addAllowedOrigin("http://canaldigital.actinver.com.mx");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("GET");
//        config.addAllowedMethod("HEAD");
//        config.addAllowedMethod("POST");
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
}