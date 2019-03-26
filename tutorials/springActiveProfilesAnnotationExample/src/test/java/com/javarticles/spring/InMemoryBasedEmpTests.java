package com.javarticles.spring;

import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles="in-memory", inheritProfiles=false)
public class InMemoryBasedEmpTests extends EmployeeTests {
    
}
