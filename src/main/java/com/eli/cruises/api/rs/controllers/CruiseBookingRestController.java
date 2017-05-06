package com.eli.cruises.api.rs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eli.cruises.api.dto.CruiseBookingDTO;
import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.mappers.impl.CruiseBookingMapperImpl;
import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.CruiseBooking;
import com.eli.cruises.persistence.entities.Ship;
import com.eli.cruises.persistence.service.CruiseBookingPersistService;
import com.eli.cruises.persistence.service.CruisePersistService;
import com.eli.cruises.persistence.service.ShipPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class CruiseBookingRestController {

	private static final Logger logger = LoggerFactory.getLogger(CruiseBookingRestController.class);
	
	private CruiseBookingPersistService bookingService;
	
	
	@Autowired
	CruiseBookingRestController(CruiseBookingPersistService bookingService) {
		
		this.bookingService = bookingService;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/bookings")
	//@Transactional
	ResponseEntity<List<CruiseBooking>> getCruiseBookings() {

		logger.debug("\n\ngetCruiseBookings\n\n");

		List<CruiseBooking> bookings = bookingService.getCruiseBookings();
		
		return new ResponseEntity<List<CruiseBooking>>(bookings,HttpStatus.OK);
	}


	@PostMapping(value="/bookings")
	//@Transactional
	ResponseEntity<CruiseBookingDTO> addOrUpdateCruiseBooking(@RequestBody CruiseBookingDTO crbkdto) {

		logger.debug("\n\naddOrUpdateCruiseBooking " + crbkdto.toString() + "\n\n");

		PreCondition.checkNotNull("CruiseBookingDTO must not be null", crbkdto);
		PreCondition.checkNotNull("SailingDTO must not be null", crbkdto.getSailing());
	
		crbkdto = bookingService.addOrUpdateCruiseBooking(crbkdto);
		
		logger.debug("\n\naddOrUpdateCruiseBooking - returning RESPONSE\n\n");

		return new ResponseEntity<CruiseBookingDTO>(crbkdto,HttpStatus.OK);
	}


	@DeleteMapping(value="/bookings")
	ResponseEntity<String> deleteCruiseBookings() {

		logger.debug("\n\ndeleteCruiseBookings\n\n");

		bookingService.deleteCruiseBookings();
		
		return new ResponseEntity<String>("CruiseBookings Deleted",HttpStatus.OK);
	}


}