package com.andrenunes.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	//Atributo usado para acessar o repositorio
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
