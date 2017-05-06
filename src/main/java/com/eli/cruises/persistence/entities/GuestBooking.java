package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.FetchType;

@Entity
@Table(name="GUESTBOOKING")
public class GuestBooking {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@OneToOne(optional=false,fetch=FetchType.EAGER)
	private Guest guest;

	@Column(name="cabin",nullable=false)
	@Pattern(regexp="[0-9][0-9]*",message="only numbers")
	@Size(min=1)
	private String cabin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public String getCabin() {
		return cabin;
	}

	public void setCabin(String cabin) {
		this.cabin = cabin;
	}

	@Override
	public String toString() {
		return "GuestBookingDTO [id=" + id + ", guest=" + guest + ", cabin=" + cabin + "]";
	}
	
	
}
