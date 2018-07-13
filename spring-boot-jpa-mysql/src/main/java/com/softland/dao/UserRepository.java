package com.softland.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.softland.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
    @Query("select c from User c where c.name = :name")
    Stream<User> findByNameReturnStream(@Param("name") String name);

}
