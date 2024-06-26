package com.codzer.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codzer.workshopmongo.domain.User;
import com.codzer.workshopmongo.dto.UserDTO;
import com.codzer.workshopmongo.repository.UserRepository;
import com.codzer.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<User> findAll()
	{
		return  userRepo.findAll();
	}
	
	public Optional<User> findById(String id)
	{
		Optional<User> usr = userRepo.findById(id);
		if(usr.isEmpty())
		{
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return usr;
	}
	
	public User insert(User obj)
	{
		return userRepo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDTO)
	{
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	
}
