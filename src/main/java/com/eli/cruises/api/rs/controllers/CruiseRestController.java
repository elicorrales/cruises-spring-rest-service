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
import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.Ship;
import com.eli.cruises.persistence.service.CruisePersistService;
import com.eli.cruises.persistence.service.ShipPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class CruiseRestController {

	private static final Logger logger = LoggerFactory.getLogger(CruiseRestController.class);
	
	private CruisePersistService cruiseService;
	private ShipPersistService shipService;
	
	
	@Autowired
	CruiseRestController(CruisePersistService cruiseService, ShipPersistService shipService) {
		
		this.cruiseService = cruiseService;
		this.shipService = shipService;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/cruises")
	ResponseEntity<List<Cruise>> getCruises() {

		logger.debug("\n\ngetCruises\n\n");

		List<Cruise> cruises = cruiseService.getCruises();
		
		return new ResponseEntity<List<Cruise>>(cruises,HttpStatus.OK);
	}


	@GetMapping(value="/cruises/{code}")
	ResponseEntity<Cruise> getCruise(@PathVariable("code") String code) {

		logger.debug("\n\ngetCruise\n\n");

		Cruise cruise = PreCondition.checkNotFound("CruiseDTO "+ code + " not found", cruiseService.getCruise(code));
		
		return new ResponseEntity<Cruise>(cruise,HttpStatus.OK);
	}


	@PostMapping(value="/cruises")
	ResponseEntity<Cruise> addOrUpdateCruise(@RequestBody Cruise cruise) {

		logger.debug("\n\naddCruise " + cruise.toString() + "\n\n");

		//PreCondition.checkNotNull("CruiseDTO must not be null", cruise);
		//PreCondition.checkNotNull("CruiseDTO ShipDTO must not be null", cruise.getShip());
	
		if (cruise.getShip().getId()==null && cruise.getShip().getCode()!=null) {
			Ship ship = shipService.getShip(cruise.getShip().getCode());
			cruise.setShip(ship);
		}

		cruiseService.addOrUpdateCruise(cruise);
		
		return new ResponseEntity<Cruise>(cruise,HttpStatus.OK);
	}


	@DeleteMapping(value="/cruises")
	ResponseEntity<String> deleteCruises() {

		logger.debug("\n\ndeleteCruises\n\n");

		cruiseService.deleteCruises();
		
		return new ResponseEntity<String>("Cruises Deleted",HttpStatus.OK);
	}


	@DeleteMapping(value="/cruises/{code}")
	ResponseEntity<String> deleteCruise(@PathVariable("code")String code) {

		logger.debug("\n\ndeleteCruise\n\n");

		cruiseService.deleteCruise(code);
		
		return new ResponseEntity<String>("CruiseDTO "+code+" Deleted",HttpStatus.OK);
	}


}