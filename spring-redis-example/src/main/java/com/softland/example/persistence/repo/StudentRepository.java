package com.softland.example.persistence.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softland.example.persistence.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
