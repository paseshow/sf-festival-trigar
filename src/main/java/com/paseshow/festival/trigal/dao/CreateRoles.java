package com.paseshow.festival.trigal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.paseshow.festival.trigal.entity.Role;
import com.paseshow.festival.trigal.enums.RoleName;
import com.paseshow.festival.trigal.services.RoleService;

@Component
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RoleService roleSerivce;
	
	@Override
	public void run(String... args) throws Exception {
		Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
		Role rolSuperAdmin = new Role(RoleName.ROLE_SUPER_ADMIN);
		Role rolUser = new Role(RoleName.ROLE_USER);
		
		roleSerivce.save(rolAdmin);
		roleSerivce.save(rolSuperAdmin);
		roleSerivce.save(rolUser);
	}
}
