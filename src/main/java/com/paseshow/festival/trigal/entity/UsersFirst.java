package com.paseshow.festival.trigal.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsersFirst implements UserDetails {
	//	class encargada de crear la seguridad
	//	determinar los privilegios de cada rol (autoridades)
		
	private String nameUser;	
	private String password;

	private Collection<? extends GrantedAuthority> authorities; //cambiamos de tipo Role a autoridades

	
	public UsersFirst(String nameUser, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nameUser = nameUser;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UsersFirst build(User user) {
		//obtenemos una lista GrantedAuthority apartir de los roles
		//convertimos la clase rol en grantedAut.
		List<GrantedAuthority> authorities = user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(
				rol.getRolName().name())).collect(Collectors.toList());
		
		return new UsersFirst(user.getNameUser(), user.getPassword(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nameUser;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
