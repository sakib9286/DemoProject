package com.boot.service;

import java.util.List;

import com.boot.model.User;

public interface UserService {
	
	public void saveOrUpdateUser(User user);
	
	public List<User> getAllUsrs();
	
	public User getUserById(long id);
	
	public void deleteUser(long id);
	
	public User Credential(String email, String password);
	
	public User getUserDetails(String email);

}
