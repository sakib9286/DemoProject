package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmailAndPassword (String email , String password);
	

	public User getUserByEmail(String email);

}
