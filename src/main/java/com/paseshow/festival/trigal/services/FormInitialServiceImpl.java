package com.paseshow.festival.trigal.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paseshow.festival.trigal.dao.FormInitialDao;
import com.paseshow.festival.trigal.entity.FormInitial;

@Service
public class FormInitialServiceImpl implements FormInitialService {

	@Autowired
	private FormInitialDao formInitialDao;
	
	@Override
	public FormInitial save(FormInitial formInitial) {
		return formInitialDao.save(formInitial);
	}

	@Override
	public List<FormInitial> findAll() {
		return formInitialDao.findAll();
	}

	@Override
	public ByteArrayInputStream exportDataFormularios() {
		
		String[] columns = {"ID", "NOMBRE", "APELLIDO", "CORREO", "TELEFONO"};
		
		Workbook workbook = new HSSFWorkbook(); 
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		
		Sheet hoja = workbook.createSheet("Formularios");
		
		CellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		
		Row filaTitulo = hoja.createRow(0);
		Cell celda = filaTitulo.createCell(0);
		
		celda.setCellValue("LISTADO DE FORMULARIOS");
		celda.setCellStyle(style);
		
		Row filaData = hoja.createRow(2);
		
		
		for(int i=0; i < columns.length; i++) {
			celda = filaData.createCell(i);
			celda.setCellValue(columns[i]);
			celda.setCellStyle(style);
		}
		
		List<FormInitial> listForm =  formInitialDao.findAll();
		
		int numFila = 3;
		for(FormInitial unForm : listForm) {
			filaData = hoja.createRow(numFila);
			
			filaData.createCell(0).setCellValue(unForm.getId());
			filaData.createCell(1).setCellValue(unForm.getNombre());
			filaData.createCell(2).setCellValue(unForm.getApellido());
			filaData.createCell(3).setCellValue(unForm.getCorreo());
			filaData.createCell(4).setCellValue(unForm.getTelefono());
			
			numFila++;
		}
		
		try {
			workbook.write(stream);
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(stream.toByteArray());
	}

}
