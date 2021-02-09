package com.paseshow.festival.trigal.services;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paseshow.festival.trigal.dto.FormInitialDTO;
import com.paseshow.festival.trigal.entity.FormInitial;

@Service
public interface FormInitialService {
	
	public FormInitial save(FormInitial formInitial);
	public List<FormInitial> findAll();
	public ByteArrayInputStream exportDataFormularios();
}
