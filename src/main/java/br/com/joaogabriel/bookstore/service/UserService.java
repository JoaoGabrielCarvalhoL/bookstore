package br.com.joaogabriel.bookstore.service;

import java.util.List;

import br.com.joaogabriel.bookstore.entity.User;

public interface UserService {

	List<User> findAll();
	
	User save(final User user);
}
