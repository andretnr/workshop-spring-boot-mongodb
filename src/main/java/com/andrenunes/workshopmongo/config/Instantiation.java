package com.andrenunes.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Barreto", "maria@gmail.com");
		User bruna = new User(null, "Bruna Barreto", "bruna@gmail.com");
		User leo = new User(null, "Leonardo Rodrigues", "leo@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, bruna, leo));
		
	}

	
}
