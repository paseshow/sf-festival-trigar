package com.paseshow.festival.trigal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.paseshow.festival.trigal.dao.EventoTrigalDao;
import com.paseshow.festival.trigal.dto.EventoTrigalDTO;
import com.paseshow.festival.trigal.entity.EventoTrigal;


@Service
public class EventoTrigalServiceImpl implements EventoTrigalService{

	
	@Autowired
	private EventoTrigalDao eventoTrigalDao;
	
	 @Override
	public EventoTrigal save (EventoTrigal eventoTrigal) {
		return eventoTrigalDao.save(eventoTrigal);
	}

	@Override
	public List<EventoTrigal> findAll() {
		return eventoTrigalDao.findAll();
	}

	
	public EventoTrigal findById(Long id) {
		try {
			Optional<EventoTrigal> tOptional = eventoTrigalDao.findById(id);
			if (tOptional.isPresent()) {
				return tOptional.get();
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean delete(EventoTrigal eventoTrigal) {
		try {
			eventoTrigalDao.delete(eventoTrigal);
			return true;
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error id no debe ser null. Error: " + e);
		} catch (PersistenceException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en el servidor. Error: " + e);
		}
	}
	
	@Override
	public List<EventoTrigal> findEventoByActve() {
		List<EventoTrigal> eventos = eventoTrigalDao.findAll();
		
		List<EventoTrigal> eventosActivos = new ArrayList<EventoTrigal>();
		
		for(EventoTrigal evento : eventos) {
			if(evento.getActive()) {
				eventosActivos.add(evento);
			}
		}
		return eventosActivos;
	}
}
