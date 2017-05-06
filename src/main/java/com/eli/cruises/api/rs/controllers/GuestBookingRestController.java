package com.eli.cruises.api.rs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.persistence.entities.GuestBooking;
import com.eli.cruises.persistence.service.GuestBookingPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class GuestBookingRestController {

	private static final Logger logger = LoggerFactory.getLogger(GuestBookingRestController.class);
	
	private GuestBookingPersistService bookingService;
	
	
	@Autowired
	GuestBookingRestController(GuestBookingPersistService bookingService) {
		
		this.bookingService = bookingService;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/guestbookings")
	ResponseEntity<List<GuestBooking>> getGuestBookings() {

		logger.debug("\n\ngetGuestBookings\n\n");

		List<GuestBooking> bookings = bookingService.getGuestBookings();
		
		return new ResponseEntity<List<GuestBooking>>(bookings,HttpStatus.OK);
	}


	@PostMapping(value="/guestbookings")
	ResponseEntity<GuestBooking> addOrUpdateGuestBooking(@RequestBody GuestBooking booking) {

		logger.debug("\n\naddOrUpdateGuestBooking " + booking.toString() + "\n\n");

		//PreCondition.checkNotNull("GuestBookingDTO must not be null", booking);
	
		bookingService.addOrUpdateGuestBooking(booking);
		
		return new ResponseEntity<GuestBooking>(booking,HttpStatus.OK);
	}


	@DeleteMapping(value="/guestbookings")
	ResponseEntity<String> deleteGuestBookings() {

		logger.debug("\n\ndeleteGuestBookings\n\n");

		bookingService.deleteGuestBookings();
		
		return new ResponseEntity<String>("GuestBookings Deleted",HttpStatus.OK);
	}


}