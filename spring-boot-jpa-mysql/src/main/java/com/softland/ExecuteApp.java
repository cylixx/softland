package com.softland;

import static java.lang.System.exit;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.Transactional;

import com.softland.dao.UserRepository;
import com.softland.model.User;

//for jsr310 java 8 java.time.*
//@EntityScan(
//      basePackageClasses = { SpringBootConsoleApplication.class, Jsr310JpaConverters.class }
//)
//@Configuration
//@EnableAutoConfiguration
@EntityScan(basePackageClasses=User.class)
@SpringBootApplication
public class ExecuteApp implements CommandLineRunner {

    @Autowired
    DataSource dataSource;
    
    @Autowired
    UserRepository userRepository;
    
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExecuteApp.class, args);
    }
    
    
    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {
     
        System.out.println("DATASOURCE = " + dataSource);

        System.out.println("\n1.findAll()...");
        for (User user : userRepository.findAll()) {
            System.out.println(user.toString());
        }
        
     // For Stream, need @Transactional
        System.out.println("\n4.findByNameReturnStream(@Param(\"name\") String name)...");
        try (Stream<User> stream = userRepository.findByNameReturnStream("Picoro")) {
            stream.forEach(x -> System.out.println(x));
        }
        
        System.out.println("Done!");
        exit(0);
    }

}
