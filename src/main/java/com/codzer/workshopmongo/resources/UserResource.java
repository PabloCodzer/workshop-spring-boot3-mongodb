package com.codzer.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codzer.workshopmongo.domain.User;
import com.codzer.workshopmongo.repository.UserRepository;
import com.codzer.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource 
{
	@Autowired
	private UserService userSer;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll()
	{
		 List<User> lisUs = userSer.findAll();
		 return ResponseEntity.ok().body(lisUs);
	}
}
