package com.javarticles.spring;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ActiveProfiles("prod")
public class EmployeeTests {
    @Autowired
    private EmployeeFinder employeeFinder;

    @Test
    public void findEmployee() {        
        Employee emp = employeeFinder.findEmployeeByName("Sam");
        Assert.assertNotNull(emp);
        Assert.assertEquals("Sam", emp.getName());
    }

    @Profile("prod")
    @Configuration
    @ComponentScan("com.javarticles.spring")
    @Sql({ "drop_schema.sql", "schema.sql", "data.sql" })
    static class ProdConfig {
        @Bean
        EmployeeFinder employeeFinder() {
            return new EmployeeFinderImpl();
        }
    }

    @Profile("in-memory")
    @Configuration
    @ComponentScan("com.javarticles.spring")
    static class TestConfig {
        static Map<String, Employee> empMap = new HashMap<String, Employee>();
        static {
            Employee emp1 = new Employee();
            emp1.setName("Sam");
            empMap.put("Sam", emp1);

            Employee emp2 = new Employee();
            emp2.setName("Joe");
            empMap.put("Joe", emp2);
        }

        @Bean
        EmployeeFinder employeeFinder() {
            return new EmployeeFinder() {

                public Employee findEmployeeByName(String name) {
                    System.out.println("Find emp from memory");
                    return empMap.get(name);
                }

            };
        }
    }
}
