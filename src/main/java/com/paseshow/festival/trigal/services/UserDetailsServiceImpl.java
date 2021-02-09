package com.paseshow.festival.trigal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paseshow.festival.trigal.entity.UsersFirst;
import com.paseshow.festival.trigal.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
		 User user = userService.getByNameUser(nameUser);
		//User user = userService.getByName(nameUser).get();
		
		return UsersFirst.build(user);
	}
	

}
