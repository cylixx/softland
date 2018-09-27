package com.actinver.eactinver.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
//@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
//	@Bean
//    WebMvcConfigurer configurer () {
//    	
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addResourceHandlers (ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**.html")
//                .addResourceLocations("classpath:/site/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/*.ico")
//                .addResourceLocations("classpath:/site/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/*.txt")
//                .addResourceLocations("classpath:/site/").setCacheControl(CacheControl.noCache());
//              
//        registry.addResourceHandler("/bower_components/**")
//                .addResourceLocations("classpath:/site/bower_components/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/fonts/**")
//                .addResourceLocations("classpath:/site/fonts/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("classpath:/site/img/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/pattern-library/**")
//                .addResourceLocations("classpath:/site/pattern-library/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/libs/**")
//                .addResourceLocations("classpath:/site/libs/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/conf/**")
//                .addResourceLocations("classpath:/site/conf/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/login-modules/**")
//                .addResourceLocations("classpath:/site/login-modules/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/main-modules/**")
//                .addResourceLocations("classpath:/site/main-modules/").setCacheControl(CacheControl.noCache());
//        
//        registry.addResourceHandler("/css/**")
//                .addResourceLocations("classpath:/site/css/").setCacheControl(CacheControl.noCache());
//
//        registry.addResourceHandler("/legales/**")
//                .addResourceLocations("classpath:/site/legales/").setCacheControl(CacheControl.noCache());
//             
//            }
//        };
//    }
	 
}
