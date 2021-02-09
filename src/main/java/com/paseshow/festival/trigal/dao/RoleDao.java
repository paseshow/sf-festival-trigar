package com.paseshow.festival.trigal.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paseshow.festival.trigal.entity.Role;
import com.paseshow.festival.trigal.enums.RoleName;

public interface RoleDao extends JpaRepository<Role, Long> {
	
	Optional<Role> findByRolName(RoleName rolName);
}
