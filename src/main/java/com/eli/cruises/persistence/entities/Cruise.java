package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="CRUISES")
public class Cruise {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@Column(name="code",nullable=false, unique=true)
	@Pattern(regexp="[A-Z][A-Z0-9]*",message="code : only letters/numbers")
	@Size(min=2)
	private String code;


	@Column(name="name",nullable=false, unique=true)
	@Pattern(regexp="[A-Z][A-Za-z ]*",message="name : only letters / spaces")
	@Size(min=2)
	private String name;

	@Column(name="description",nullable=false, unique=true)
	@Pattern(regexp="[A-Z][A-Za-z ]*",message="description : only letters / spaces")
	@Size(min=2)
	private String description;

	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	private Ship ship;

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

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public String toString() {
		return "CruiseDTO [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", ship="
				+ ship + "]";
	}

	
	
}
