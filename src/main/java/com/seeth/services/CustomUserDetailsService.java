package com.seeth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seeth.Repositories.UserRespository;
import com.seeth.models.CustomUserDetails;
import com.seeth.models.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRespository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByName(username);
		optionalUsers.orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
