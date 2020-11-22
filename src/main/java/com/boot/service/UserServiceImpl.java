package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.User;
import com.boot.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveOrUpdateUser(User user) {
		user.setInter(String.join(",", user.getInterest()));
		userRepository.save(user);
	}
	

	@Override
	public List<User> getAllUsrs() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		return userRepository.findById(id).get();
		
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}


	@Override
	public User Credential(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}


	@Override
	public User getUserDetails(String email) {
		return userRepository.getUserByEmail(email);
	}



	
}
