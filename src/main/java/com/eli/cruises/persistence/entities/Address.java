package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="ADDRESSES", 
	uniqueConstraints={ @UniqueConstraint(columnNames = {
			"address1", "address2","city_id","state_id","zip"})
	})
public class Address {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@Column(name="address1",nullable=false)
	//@Pattern(regexp="[0-9A-Za-z0-9 ]*",message="only letters/numbers/spaces")
	@Size(min=2)
	private String address1;

	@Column(name="address2",nullable=false)
	//@Pattern(regexp="[0-9A-Za-z0-9 ]*",message="only letters/numbers/spaces")
	@Size(min=2)
	private String address2;
	
	// any changes in address should NOT affect city
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="city_id")
	private City city;
	
	// any changes in address should NOT affect state
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name="state_id")
	private State  state;
	
	@Column(name="zip",nullable=false)
	@Pattern(regexp="[0-9][0-9]*",message="postal code : only numbers")
	@Size(min=5)
	private String zip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city + ", state="
				+ state + ", zip=" + zip + "]";
	}
	
	
}
