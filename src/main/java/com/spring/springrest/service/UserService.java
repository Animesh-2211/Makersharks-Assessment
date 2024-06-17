package com.spring.springrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springrest.model.User;
import com.spring.springrest.repository.UserRepository;

@Service
public class UserService {

	// For in Memory Storage

	// private Map<String, User> userStorage=new HashMap<>();
	//
	//
	//
	// public boolean checkUser(User user) {
	// if(userStorage.containsKey(user.getUsername())) {
	// return false;
	// }
	// userStorage.put(user.getUsername(), user);
	// return true;
	// }
	//
	// public User fetchUser(String username) {
	// return userStorage.get(username);
	// }

	@Autowired
	private UserRepository userRepository;

	public boolean checkUser(String username) {
		return userRepository.existsById(username);
	}

	public User fetchUser(String username) {
		return userRepository.findById(username).orElse(null);
	}

	public User registerUser(User user) {

		return userRepository.save(user);
	}

}