package com.paseshow.festival.trigal.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewUser {

	@NotBlank
	private String nameUser;
	
	@NotBlank
	private String password;
	

	public String getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}


	private Set<String> roles = new HashSet<>();
	
}
