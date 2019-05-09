package com.example.springbootrestexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootrestexample.vo.Post;
import com.example.springbootrestexample.vo.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
