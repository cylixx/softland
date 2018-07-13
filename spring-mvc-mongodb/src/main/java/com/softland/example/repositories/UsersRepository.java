package com.softland.example.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.softland.example.model.Users;


@Repository
public interface UsersRepository extends MongoRepository<Users, String> {

}