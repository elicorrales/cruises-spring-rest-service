package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.persistence.entities.CruiseBooking;
import com.eli.cruises.persistence.entities.GuestBooking;


public interface GuestBookingPersistService {

	void deleteGuestBookings();

	List<GuestBooking> getGuestBookings();
	
	void addOrUpdateGuestBooking(GuestBooking booking);
	
}
