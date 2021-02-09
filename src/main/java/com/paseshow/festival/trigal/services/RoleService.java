package com.paseshow.festival.trigal.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paseshow.festival.trigal.dao.RoleDao;
import com.paseshow.festival.trigal.entity.Role;
import com.paseshow.festival.trigal.enums.RoleName;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	RoleDao roleDao;
	
	public Optional<Role> getByRolName(RoleName rolName) {
		return roleDao.findByRolName(rolName);
	}
	
	public void save(Role rol) {
		roleDao.save(rol);
	}

}
