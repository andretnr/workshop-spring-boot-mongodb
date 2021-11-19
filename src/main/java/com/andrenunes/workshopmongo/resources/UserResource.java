package com.andrenunes.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	//Atributo usado para acessar as classes de serviço
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){	
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
