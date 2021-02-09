package com.paseshow.festival.trigal.controllers;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paseshow.festival.trigal.dto.FormInitialDTO;
import com.paseshow.festival.trigal.entity.FormInitial;
import com.paseshow.festival.trigal.services.FormInitialServiceImpl;

@RestController
@RequestMapping("/Formularios")
@CrossOrigin
public class FormInitialController {
	
	@Autowired
	private FormInitialServiceImpl formInitialServiceImpl;
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@PostMapping(name = "add", path = "add")
	public ResponseEntity<?> addFormulario (@Valid @RequestBody FormInitial formInital) {
		formInitialServiceImpl.save(formInital);
		
		return ResponseEntity.ok().body("");
	}
	
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	@GetMapping(name = "list", path = "list")
	public ResponseEntity<?> listFormularios() {
		List<FormInitial> listFormularios =  formInitialServiceImpl.findAll();
		
		if(listFormularios.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lista vacia");
		}
		
		return ResponseEntity.ok().body(listFormularios);
	}
	
	
	@GetMapping(name = "excel" , path = "export/listado")
	public ResponseEntity<InputStreamResource> reporteExcelFormularios() {
		
		ByteArrayInputStream stream = formInitialServiceImpl.exportDataFormularios();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","attachment; filename=listadoFormularios.xlsx");
		
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}
}
