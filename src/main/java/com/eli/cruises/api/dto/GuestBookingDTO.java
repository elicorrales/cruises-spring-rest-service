package com.eli.cruises.api.dto;

import javax.persistence.FetchType;

public class GuestBookingDTO {

	private Long id;

	private GuestDTO guest;

	private String cabin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GuestDTO getGuest() {
		return guest;
	}

	public void setGuest(GuestDTO guest) {
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
