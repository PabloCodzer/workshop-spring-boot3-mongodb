package com.codzer.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codzer.workshopmongo.domain.Post;
import com.codzer.workshopmongo.repository.PostRepository;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll()
	{
		List<Post> listPosts = postRepository.findAll();
		return ResponseEntity.ok().body(listPosts);
	}
}
