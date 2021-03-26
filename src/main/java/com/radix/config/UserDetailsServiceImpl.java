package com.radix.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.radix.entities.User;
import com.radix.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// fetching user from database
		  User user= userRepository.getUserByName(username);
		  if(user==null)
		  {
			      throw new UsernameNotFoundException("Colud not found user!!");
			      
		  }
		  CustomUserDetails customUserDetails=new CustomUserDetails(user);
		  
		return customUserDetails;
	}
	

}
