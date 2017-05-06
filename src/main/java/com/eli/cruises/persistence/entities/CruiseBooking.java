package com.eli.cruises.persistence.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CRUISEBOOKING")
public class CruiseBooking {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@OneToOne(optional=false,fetch=FetchType.EAGER)
	private Sailing sailing;

	@ElementCollection
	@OneToMany(fetch=FetchType.EAGER)
	private List<GuestBooking> guestBookings;

	@ElementCollection
	@OneToMany(fetch=FetchType.EAGER)
	private List<Payment> payments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sailing getSailing() {
		return sailing;
	}

	public void setSailing(Sailing sailing) {
		this.sailing = sailing;
	}

	public List<GuestBooking> getGuestBookings() {
		return guestBookings;
	}

	public void setGuestBookings(List<GuestBooking> guestBookings) {
		this.guestBookings = guestBookings;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "CruiseBookingDTO [id=" + id + ", sailing=" + sailing + ", guestBookings=" + guestBookings + ", payments="
				+ payments + "]";
	}


}
