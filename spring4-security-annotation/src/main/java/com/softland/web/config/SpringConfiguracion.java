package com.softland.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@EnableWebMvc
@Configuration
@ComponentScan("com.softland.web.*")
@Import({SpringConfiguracionSeguridad.class})
public class SpringConfiguracion {
     
     
     @Bean
        public ViewResolver viewResolver() {
         System.out.println("llega");
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("/WEB-INF/vistas/");
            viewResolver.setSuffix(".jsp");
 
            return viewResolver;
        }
 
}