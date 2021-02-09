package com.paseshow.festival.trigal.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.paseshow.festival.trigal.enums.RoleName;
import com.sun.istack.NotNull;

@Table
@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleName rolName;
	

	public Role() {
		super();
	}

	public Role(RoleName rolName) {
		super();
		this.rolName = rolName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleName getRolName() {
		return rolName;
	}

	public void setRolName(RoleName rolName) {
		this.rolName = rolName;
	}
	
	

}
