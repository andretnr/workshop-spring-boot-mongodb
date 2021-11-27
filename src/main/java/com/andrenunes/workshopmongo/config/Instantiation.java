package com.andrenunes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andrenunes.workshopmongo.domain.Post;
import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.repository.PostRepository;
import com.andrenunes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Barreto", "maria@gmail.com");
		User bruna = new User(null, "Bruna Barreto", "bruna@gmail.com");
		User leo = new User(null, "Leonardo Rodrigues", "leo@gmail.com");
		User andre = new User(null, "André Nunes", "andre@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/11/2021"), "Bora tatuar?", "Quero tatuar uma caveira, algum voluntário?", andre);
		Post post2 = new Post(null, sdf.parse("22/11/2021"), "Compro carro", "Procuro carro bom e barato pra comprar", andre);
		
		userRepository.saveAll(Arrays.asList(maria, bruna, leo, andre));
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
