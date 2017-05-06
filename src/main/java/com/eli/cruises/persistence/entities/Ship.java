package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.eli.cruises.enums.ShipStatus;

@Entity
@Table(name="SHIPS")
public class Ship {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;

	@Column(name="code",nullable=false,unique=true)
	@Pattern(regexp="[A-Z][A-Z]",message="code : only 2 letters")
	@Size(min=2,max=2)
	private String code;
	
	@Column(name="name", nullable=false, unique=true)
	@Pattern(regexp="[A-Z][a-z]*",message="name : only letters")
	@Size(min=2)
	private String name;

	@Column (name="description", nullable=false,unique=true)
	@Pattern(regexp="[A-Z][A-Za-z ]*",message="description : only letters / spaces")
	@Size(min=2)
	private String description;
	
	@Column(name="numCabins", nullable=false)
	private Integer numCabins;

	@Enumerated(EnumType.STRING)
	@Column(name="status",nullable=false)
	private ShipStatus status;

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

	public Integer getNumCabins() {
		return numCabins;
	}

	public void setNumCabins(Integer numCabins) {
		this.numCabins = numCabins;
	}

	public ShipStatus getStatus() {
		return status;
	}

	public void setStatus(ShipStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShipDTO [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", numCabins="
				+ numCabins + ", status=" + status + "]";
	}


	
}
