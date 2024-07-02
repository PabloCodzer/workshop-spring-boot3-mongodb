package com.codzer.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codzer.workshopmongo.domain.Post;
import com.codzer.workshopmongo.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	public List<Post> findAll()
	{
		return postRepository.findAll();
	}
	
	
	
}
