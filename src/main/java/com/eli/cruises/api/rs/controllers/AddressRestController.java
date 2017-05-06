package com.eli.cruises.api.rs.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eli.cruises.api.dto.AddressDTO;
import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.persistence.entities.Address;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.service.AddressPersistService;
import com.eli.cruises.persistence.service.CityPersistService;

/*
 * at the moment I dont think there's an actual need to expose just 'Address',
 * a guest.  (that may change later.
 * 
 * however, this controller is just to make testing easier
 * 
 */
@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class AddressRestController {

	private static final Logger logger = LoggerFactory.getLogger(AddressRestController.class);
	
	private AddressPersistService service;
	
	
	@Autowired
	AddressRestController(AddressPersistService service) {
		
		this.service = service;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/addresses")
	ResponseEntity<List<Address>> getAddresses() {

		logger.debug("\n\ngetAddresses\n\n");

		List<Address> addresses = service.getAddresses();
		
		addresses.stream().forEach((a)->{logger.debug("\n\n"+a.toString()+"\n\n");});

		return new ResponseEntity<List<Address>>(addresses,HttpStatus.OK);
	}


	@DeleteMapping(value="/addresses")
	ResponseEntity<String> deleteAddresses() {

		logger.debug("\n\ndeleteAddresses\n\n");

		service.deleteAddresses();
		
		return new ResponseEntity<String>("Addresses Deleted",HttpStatus.OK);
	}


}