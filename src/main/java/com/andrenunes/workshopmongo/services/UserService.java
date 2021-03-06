package com.andrenunes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrenunes.workshopmongo.domain.User;
import com.andrenunes.workshopmongo.dto.UserDTO;
import com.andrenunes.workshopmongo.repository.UserRepository;
import com.andrenunes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// Atributo usado para acessar o repositorio
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User Insert(User obj) {
		return repo.insert(obj);
	}

	public void remove(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		findById(obj.getId());
		User oldObj = findById(obj.getId());
		updateData(oldObj, obj);
		return repo.save(oldObj);
	}

	private void updateData(User oldObj, User obj) {
		oldObj.setName(obj.getName());
		oldObj.setEmail(obj.getEmail());	
	}

	public User FromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
