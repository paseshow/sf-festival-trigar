package com.paseshow.festival.trigal.controllers;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paseshow.festival.trigal.dto.EventoTrigalDTO;
import com.paseshow.festival.trigal.entity.EventoTrigal;
import com.paseshow.festival.trigal.services.EventoTrigalServiceImpl;


@RestController
@RequestMapping("/eventoes")
@CrossOrigin
public class EventoTrigalController {
	
	@Autowired
	private EventoTrigalServiceImpl eventoTrigalServiceImpl;
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@PostMapping(name="add", path = "add")
	public ResponseEntity<EventoTrigal> addNewEvento (
			@Valid @RequestBody EventoTrigalDTO eventoTrigal, BindingResult bindingResult)
	{
		EventoTrigal evento = new EventoTrigal();
		evento.setNameEvento(eventoTrigal.getNameEvento());
		evento.setLinkEvento(eventoTrigal.getLinkEvento());
		evento.setActive(eventoTrigal.getActive());
		evento.setFechaEvento(eventoTrigal.getFechaEvento());
		
		EventoTrigal eventoLoad = eventoTrigalServiceImpl.save(evento);
		
		return ResponseEntity.ok().body(eventoLoad);
	};
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@GetMapping(name="listAll", path = "listAll")
	public ResponseEntity<?> listAllEvents() {
		
		List<EventoTrigal> eventos = eventoTrigalServiceImpl.findAll();
		
		return ResponseEntity.ok().body(eventos);
		
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@DeleteMapping(name="deleteEvento", path="{idEvento}")
	public ResponseEntity<?> deletEventoById (@PathVariable("idEvento") Long id) {
		if(id == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id no debe estar vacio");
		}
		
		EventoTrigal event = eventoTrigalServiceImpl.findById(id);
		
		if(event.getId() != null) {
			if(eventoTrigalServiceImpl.delete(event)) {
			return ResponseEntity.ok().body("Evento eliminado correctamente");
			}
		}	
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al eliminar");
		
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@PutMapping(name="updateEvent", path = "update")
	public ResponseEntity<List<EventoTrigal>> updateEvento(@Valid @RequestBody EventoTrigal eventUpdate) {
		EventoTrigal eventoUpdate = eventoTrigalServiceImpl.save(eventUpdate);
		
		List<EventoTrigal> listEventsActuales = eventoTrigalServiceImpl.findAll();
		
		return ResponseEntity.ok().body(listEventsActuales);
	}
	
	
	@GetMapping(name = "eventoHabilitado", path="")
	public ResponseEntity<?> eventoHabilitado() {
		List<EventoTrigal> eventos = eventoTrigalServiceImpl.findEventoByActve();
		
		if(eventos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al consultar eventos");
		}
		 return ResponseEntity.ok().body(eventos);
	}
}
