package com.paseshow.festival.trigal.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

public class EventoTrigalDTO {
	
	@NotNull
	private String nameEvento;
	
	@NotNull
	private String linkEvento;
	
	@NotNull
	private Boolean active;
	
	@NotNull
	private String fechaEvento;

	
	@JsonCreator
	public EventoTrigalDTO(
			@JsonProperty ("nameEvento") String nameEvento,
			@JsonProperty ("linkEvento") String linkEvento,
			@JsonProperty ("active") Boolean active,
			@JsonProperty ("fechaEvento") String fechaEvento
			) {
		this.nameEvento = nameEvento;
		this.linkEvento = linkEvento;
		this.active = active;
		this.fechaEvento = fechaEvento;
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
