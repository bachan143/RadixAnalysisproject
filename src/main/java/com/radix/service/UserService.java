package com.radix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.radix.entities.CalendarEvent;
import com.radix.entities.User;
import com.radix.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	public User saveUserData(User user)
	{
		user.setRole("ROLE_USER");
		  user.setEnabled(true);
		  user.setPassword(passwordEncoder.encode(user.getPassword()));
		    
		  return this.userRepository.save(user);
	}
	public User getUserDetails(String name)
	{
		return userRepository.getUserByName(name);
	}
	
	

}
