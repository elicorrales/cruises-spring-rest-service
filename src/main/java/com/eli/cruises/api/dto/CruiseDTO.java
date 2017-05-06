package com.eli.cruises.api.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class CruiseDTO {

	private Long id;

	private String code;

	private String name;

	private String description;

	private ShipDTO ship;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ShipDTO getShip() {
		return ship;
	}

	public void setShip(ShipDTO ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "CruiseDTO [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", ship="
				+ ship + "]";
	}

	
	
}
