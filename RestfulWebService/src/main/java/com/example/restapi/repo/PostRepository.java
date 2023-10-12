package com.example.restapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
