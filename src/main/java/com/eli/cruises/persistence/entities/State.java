package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="STATES")
public class State {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@Column(name="code",nullable=false, unique=true)
	@Pattern(regexp="[A-Z][A-Z]",message="only letters")
	@Size(min=2,max=2)
	private String code;


	@Column(name="name",nullable=false, unique=true)
	@Pattern(regexp="[A-Z][a-z]*",message="only letters")
	@Size(min=2)
	private String name;


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


	@Override
	public String toString() {
		return "State [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	
}
