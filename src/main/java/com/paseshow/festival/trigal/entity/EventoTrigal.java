package com.paseshow.festival.trigal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Table
@Entity
public class EventoTrigal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nameEvento;
	
	private String linkEvento;
	
	@NotNull
	private Boolean active;
	
	private String fechaEvento;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameEvento() {
		return nameEvento;
	}

	public void setNameEvento(String nameEvento) {
		this.nameEvento = nameEvento;
	}

	public String getLinkEvento() {
		return linkEvento;
	}

	public void setLinkEvento(String linkEvento) {
		this.linkEvento = linkEvento;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	
	
}
