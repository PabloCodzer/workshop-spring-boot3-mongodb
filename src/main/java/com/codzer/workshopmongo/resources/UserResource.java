package com.codzer.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.codzer.workshopmongo.domain.User;
import com.codzer.workshopmongo.dto.UserDTO;
import com.codzer.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource 
{
	@Autowired
	private UserService userSer;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll()
	{
		 List<User> lisUs = userSer.findAll();
		 List<UserDTO> listDTO = lisUs.stream().map(  x -> new UserDTO(x)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value= "/{id}" , method=RequestMethod.GET)
	public ResponseEntity<Optional<User>> findById(@PathVariable String id)
	{
		Optional<User> obj = userSer.findById(id);
		return  ResponseEntity.ok().body( obj );
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<List<UserDTO>> insert(@RequestBody UserDTO objDTO)
	{
		 User lisUs = userSer.fromDTO(objDTO);
		 lisUs = userSer.insert(lisUs);
		 URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(lisUs.getId()).toUri();
		 return ResponseEntity.created(uri).build();
	}
}
