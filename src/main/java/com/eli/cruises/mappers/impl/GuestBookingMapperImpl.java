package com.eli.cruises.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.eli.cruises.api.dto.GuestBookingDTO;
import com.eli.cruises.persistence.entities.GuestBooking;

public class GuestBookingMapperImpl {

	static public List<GuestBooking> guestBookingDtosToGuestBookingEntities(List<GuestBookingDTO> list) {
		
		List<GuestBooking> entities = new ArrayList<GuestBooking>(list.size());

		list.stream().forEach(a -> {
			GuestBooking gbk = new GuestBooking();
			gbk.setId(a.getId());
			gbk.setGuest(GuestMapperImpl.guestDtoToGuestEntity(a.getGuest()));
			gbk.setCabin(a.getCabin());
			entities.add(gbk);
		});
		
		return entities;
	}

	static public GuestBookingDTO guestBookingEntityToGuestBookingDto(GuestBooking entity) {
		// TODO Auto-generated method stub
		return null;
	}

	static public GuestBooking guestBookingDtoToGuestBookingEntity(GuestBookingDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
