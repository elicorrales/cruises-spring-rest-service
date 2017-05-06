package com.eli.cruises.api.dto;

import java.util.List;

public class CruiseBookingDTO {

	private Long id;

	private SailingDTO sailing;

	private List<GuestBookingDTO> guestBookings;

	private List<PaymentDTO> payments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SailingDTO getSailing() {
		return sailing;
	}

	public void setSailing(SailingDTO sailing) {
		this.sailing = sailing;
	}

	public List<GuestBookingDTO> getGuestBookings() {
		return guestBookings;
	}

	public void setGuestBookings(List<GuestBookingDTO> guestBookings) {
		this.guestBookings = guestBookings;
	}

	public List<PaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDTO> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "CruiseBookingDTO [id=" + id + ", sailing=" + sailing + ", guestBookings=" + guestBookings + ", paymentIds="
				+ payments + "]";
	}


}
