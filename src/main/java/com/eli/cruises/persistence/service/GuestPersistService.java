package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.api.dto.GuestDTO;
import com.eli.cruises.persistence.entities.Guest;


public interface GuestPersistService {

	void deleteGuests();

	List<GuestDTO> getGuests();
	
	GuestDTO addOrUpdateGuest(GuestDTO dto);
	
}
