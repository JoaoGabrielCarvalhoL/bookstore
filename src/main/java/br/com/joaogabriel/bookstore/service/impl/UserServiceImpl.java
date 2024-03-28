package br.com.joaogabriel.bookstore.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.joaogabriel.bookstore.entity.User;
import br.com.joaogabriel.bookstore.repository.UserRepository;
import br.com.joaogabriel.bookstore.service.UserService;

public class UserServiceImpl implements UserService {
	
	private final Logger logger = Logger.getLogger(getClass().getName());
	private final UserRepository userRepository;

	public UserServiceImpl() {
		this.userRepository = new UserRepository(User.class);
	}
	
	@Override
	public List<User> findAll() {
		logger.info("Getting all users");
		return this.userRepository.list();
	}

	@Override
	public User save(User user) {
		logger.log(Level.INFO, "Saving user: {0} into database.", user);
		return this.userRepository.save(user);
		
	}

}
