package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.cruises.persistence.entities.GuestBooking;
import com.eli.cruises.persistence.repository.GuestBookingRepository;
import com.eli.cruises.persistence.service.GuestBookingPersistService;


@Service
class GuestBookingPersistServiceImpl implements GuestBookingPersistService {

	private static final Logger logger = LoggerFactory.getLogger(GuestBookingPersistServiceImpl.class);
	

	private GuestBookingRepository repository;
	
	@Autowired
	GuestBookingPersistServiceImpl(GuestBookingRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public void deleteGuestBookings() {

		repository.deleteAll();
	}

	@Override
	public List<GuestBooking> getGuestBookings() {

		return repository.findAll();
	}

	@Override
	public void addOrUpdateGuestBooking(GuestBooking booking) {

		repository.save(booking);
	}

}
