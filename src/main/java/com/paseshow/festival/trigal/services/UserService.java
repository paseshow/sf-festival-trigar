package com.paseshow.festival.trigal.services;

import java.util.List;
import java.util.Optional;

import com.paseshow.festival.trigal.dao.UserDao;
import com.paseshow.festival.trigal.entity.User;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;
	
	public User getByNameUser(String nameUser) {
		User use = userDao.findByNameUser(nameUser);
		return use;
	}
	
	public boolean existsByNameUser(String nameUser) {
		return userDao.existsByNameUser(nameUser);
	}
	
	public void save(User user) {
		userDao.save(user);
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	public User findById(Long id) {
		try {
			return userDao.findByid(id);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean delete(User user) {
		try {
			userDao.delete(user);
			return true;
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error id no debe ser null. Error: " + e);
		} catch (PersistenceException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor. Error: " + e);
		}
	}
	
}
