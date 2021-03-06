package com.andrenunes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andrenunes.workshopmongo.domain.Post;
import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.dto.AuthorDTO;
import com.andrenunes.workshopmongo.dto.CommentDTO;
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

		userRepository.saveAll(Arrays.asList(maria, bruna, leo, andre));
		
		Post post1 = new Post(null, sdf.parse("21/11/2021"), "Bora tatuar?", "Quero tatuar uma caveira, algum voluntário?", new AuthorDTO(andre));
		Post post2 = new Post(null, sdf.parse("22/11/2021"), "Compro carro", "Procuro carro bom e barato pra comprar", new AuthorDTO(andre));
		
		CommentDTO comment1 = new CommentDTO("Eu quero mano", sdf.parse("24/11/2021"), new AuthorDTO(bruna));
		CommentDTO comment2 = new CommentDTO("Marca pra terminar meu braço logo!", sdf.parse("25/11/2021"), new AuthorDTO(leo));
		CommentDTO comment3 = new CommentDTO("To vendendo um novinho", sdf.parse("25/11/2021"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(comment1, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));

		bruna.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(bruna);
		
		
	}

}
