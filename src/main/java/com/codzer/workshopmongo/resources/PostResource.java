package com.codzer.workshopmongo.resources;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codzer.workshopmongo.domain.Post;
import com.codzer.workshopmongo.repository.PostRepository;
import com.codzer.workshopmongo.resources.util.URL;
import com.codzer.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postRepository;
	
	@GetMapping
	public ResponseEntity<List<Post>> findAll()
	{
		List<Post> listPosts = postRepository.findAll();
		return ResponseEntity.ok().body(listPosts);
	}
	
	@RequestMapping(value = "{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id)
	{
		Post  pst =  postRepository.findById(id);
		if( pst != null )
		{
			return ResponseEntity.ok().body(pst);
		}
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue = "") String text)
	{
		text = URL.decodeParam(text);
		List<Post> list = postRepository.findByTitle(text);
		return ResponseEntity.ok().body(list); 
	}
}
