package com.codzer.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codzer.workshopmongo.domain.Post;
import com.codzer.workshopmongo.repository.PostRepository;
import com.codzer.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	public List<Post> findAll()
	{
		return postRepository.findAll();
	}
	
	public Post findById(String id)
	{
		Optional<Post> user = postRepository.findById(id);
		if(user.isEmpty())
		{
			throw new ObjectNotFoundException("Post não encontrado");
		}
		return user.get();
	}
	
	public List<Post> findByTitle(String text)
	{
		//return postRepository.findByTitleContainingIgnoreCase(text);
		return postRepository.seachTitle(text);
	}
}
