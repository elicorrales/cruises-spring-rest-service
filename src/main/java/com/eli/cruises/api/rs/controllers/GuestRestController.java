package com.eli.cruises.api.rs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eli.cruises.api.dto.GuestDTO;
import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.persistence.entities.Guest;
import com.eli.cruises.persistence.service.AddressPersistService;
import com.eli.cruises.persistence.service.GuestPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class GuestRestController {

	private static final Logger logger = LoggerFactory.getLogger(GuestRestController.class);
	
	private GuestPersistService guestService;
	//private AddressPersistService addressService;
	
	
	@Autowired
	GuestRestController(
			GuestPersistService guestService
			//, AddressPersistService addressService
			) {
		
		this.guestService = guestService;
		//this.addressService = addressService;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/guests")
	ResponseEntity<List<GuestDTO>> getGuests() {

		logger.debug("\n\ngetGuests\n\n");

		List<GuestDTO> dtos = guestService.getGuests();
		
		return new ResponseEntity<List<GuestDTO>>(dtos,HttpStatus.OK);
	}


	@PostMapping(value="/guests")
	ResponseEntity<GuestDTO> addOrUpdateGuest(@RequestBody GuestDTO dto) {

		logger.debug("\n\naddGuest " + dto.toString() + "\n\n");

		//PreCondition.checkNotNull("GuestDTO must not be null", dto);
		//PreCondition.checkNotNull("AddressDTO must not be null", dto.getAddressDTO());

		logger.debug("\n\naddGuest - saving guest \n\n");

		dto = guestService.addOrUpdateGuest(dto);
		
		return new ResponseEntity<GuestDTO>(dto,HttpStatus.OK);
	}


	@DeleteMapping(value="/guests")
	ResponseEntity<String> deleteGuests() {

		logger.debug("\n\ndeleteGuests\n\n");

		guestService.deleteGuests();
		
		return new ResponseEntity<String>("Guests Deleted",HttpStatus.OK);
	}

}