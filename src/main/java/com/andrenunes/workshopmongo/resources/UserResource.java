package com.andrenunes.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.dto.UserDTO;
import com.andrenunes.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	// Atributo usado para acessar as classes de serviço
	@Autowired
	private UserService service;

	// Metodo que retorna toda a lista de usuários
	// anotação pode ser substituida por @GetMapping
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(users -> new UserDTO(users)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	// Metodo que retorna usuário pelo ID
	// anotação pode ser substituida por @GetMapping
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	// Metodo de inserção de usuário
	// anotação pode ser substituida por @PostMapping
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
		User obj = service.FromDTO(objDTO);
		obj = service.Insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
