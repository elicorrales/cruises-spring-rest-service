package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.api.dto.CruiseBookingDTO;
import com.eli.cruises.persistence.entities.CruiseBooking;


public interface CruiseBookingPersistService {

	void deleteCruiseBookings();

	List<CruiseBooking> getCruiseBookings();
	
	CruiseBookingDTO addOrUpdateCruiseBooking(CruiseBookingDTO booking);
	
}
