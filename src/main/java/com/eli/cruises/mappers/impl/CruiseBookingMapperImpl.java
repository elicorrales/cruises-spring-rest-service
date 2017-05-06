package com.eli.cruises.mappers.impl;

import com.eli.cruises.api.dto.CruiseBookingDTO;
import com.eli.cruises.persistence.entities.CruiseBooking;

public class CruiseBookingMapperImpl { 

	static public CruiseBookingDTO cruiseBookingEntityToCruiseBookingDto(CruiseBooking entity) {

		CruiseBookingDTO dto = null;
		if (null!=entity) {
			dto = new CruiseBookingDTO();
			dto.setId(entity.getId());
			dto.setSailing(SailingMapperImpl.sailingEntityToSailingDto(entity.getSailing()));
			dto.setPayments(PaymentMapperImpl.paymentEntitiesToPaymentDtos(entity.getPayments()));
		}
		return dto;
	}

	static public CruiseBooking cruiseBookingDtoToCruiseBookingEntity(CruiseBookingDTO dto) {

		CruiseBooking booking = null;
		if (null!=dto) {
			booking = new CruiseBooking();
			booking.setId(dto.getId());
			booking.setGuestBookings(GuestBookingMapperImpl.guestBookingDtosToGuestBookingEntities(dto.getGuestBookings()));
			booking.setPayments(PaymentMapperImpl.paymentDtosToPaymentEntities(dto.getPayments()));
			booking.setSailing(SailingMapperImpl.sailingDtoToSailingEntity(dto.getSailing()));
		}
		return booking;
	}

}
