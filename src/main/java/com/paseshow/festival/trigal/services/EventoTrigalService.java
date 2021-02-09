package com.paseshow.festival.trigal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paseshow.festival.trigal.dto.EventoTrigalDTO;
import com.paseshow.festival.trigal.entity.EventoTrigal;


@Service
public interface EventoTrigalService {
	
	public EventoTrigal save(EventoTrigal eventoTrigal);
	public List<EventoTrigal> findAll();
	public EventoTrigal findById(Long id);
	public Boolean delete(EventoTrigal eventoTrigal);
	List<EventoTrigal> findEventoByActve();
}
