package com.codzer.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codzer.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource 
{
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll()
	{
		 User maria = new User("1", "seui la maria", "rh@fera.com");
		 User alequis = new User("1", "alequis sandro", "alequis.sandro@fera.com");
		 
		 List<User> lisUs = new ArrayList<>();
		 lisUs.addAll(Arrays.asList(  maria, alequis  ));
		 
		 return ResponseEntity.ok().body(lisUs);
	}
}
