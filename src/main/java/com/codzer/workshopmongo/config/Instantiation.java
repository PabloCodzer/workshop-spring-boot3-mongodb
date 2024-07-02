package com.codzer.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.codzer.workshopmongo.domain.Post;
import com.codzer.workshopmongo.domain.User;
import com.codzer.workshopmongo.dto.AuthorDTO;
import com.codzer.workshopmongo.repository.PostRepository;
import com.codzer.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(  Arrays.asList(maria,alex, bob )  );
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Post 1 - algum titulo", "Viagem sem gastar nada", new AuthorDTO(maria) );
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Post 2 - Mudança de vida", "Vou mudar de vida com java", new AuthorDTO(maria));
		
		postRepository.saveAll( Arrays.asList(post1, post2) ); 
		
		maria.getPosts().addAll( Arrays.asList(post2, post1));
		userRepository.save(maria);
	}

}
