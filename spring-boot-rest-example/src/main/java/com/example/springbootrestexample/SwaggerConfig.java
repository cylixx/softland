/**
 * Para acceder a la documentacion
 * http://localhost:8080/v2/api-docs
 * 
 * Para acceder a swagger
 * http://localhost:8080/swagger-ui.html
 */
package com.example.springbootrestexample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	  public static final Contact DEFAULT_CONTACT = new Contact("Marco A. Hinojosa", "http://www.cylixx.com", "mhinojosa@gmail.com");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title", "Awesome API description", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	  public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
			  new HashSet<String>(Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO);
	}
}
