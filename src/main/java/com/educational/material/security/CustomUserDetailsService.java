package com.educational.material.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("Vinay")) {
			return new User("user_Vinay", "pwd_tiwari", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found !!");
		}
	}

}
