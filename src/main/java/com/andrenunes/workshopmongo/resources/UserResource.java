package com.andrenunes.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.dto.UserDTO;
import com.andrenunes.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	//Atributo usado para acessar as classes de serviço
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){	
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(users -> new UserDTO(users)).collect(Collectors.toList());		
		return ResponseEntity.ok().body(listDto);
	}
}
