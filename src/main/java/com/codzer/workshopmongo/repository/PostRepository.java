package com.codzer.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codzer.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
