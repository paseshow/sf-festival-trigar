package com.paseshow.festival.trigal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paseshow.festival.trigal.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	User findByNameUser(String nameUser);
	boolean existsByNameUser(String nameUser);
	List<User> findAll();
	void deleteById(Long id);
	User findByid(Long id);
	void delete(User user);
	
}
