package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="CITIES")
public class City {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@Column(name="name",nullable=false, unique=true)
	@Pattern(regexp="[A-Za-z ]*",message="only letters")
	@Size(min=2)
	private String name;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}

	
}
