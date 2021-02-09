package com.paseshow.festival.trigal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paseshow.festival.trigal.entity.EventoTrigal;

public interface EventoTrigalDao extends JpaRepository<EventoTrigal, Long>{
	
	
}
