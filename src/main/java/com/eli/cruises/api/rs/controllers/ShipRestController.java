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
import com.eli.cruises.persistence.entities.Ship;
import com.eli.cruises.persistence.service.ShipPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class ShipRestController {

	private static final Logger logger = LoggerFactory.getLogger(ShipRestController.class);
	
	private ShipPersistService service;
	
	
	@Autowired
	ShipRestController(ShipPersistService service) {
		
		this.service = service;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/ships")
	ResponseEntity<List<Ship>> getShips() {

		logger.debug("\n\ngetShips\n\n");

		List<Ship> ships = service.getShips();
		
		return new ResponseEntity<List<Ship>>(ships,HttpStatus.OK);
	}


	@GetMapping(value="/ships/{code}")
	ResponseEntity<Ship> getShip(@PathVariable("code") String code) {

		logger.debug("\n\ngetShip\n\n");

		Ship ship = PreCondition.checkNotFound("ShipDTO "+ code + " not found", service.getShip(code));
		
		return new ResponseEntity<Ship>(ship,HttpStatus.OK);
	}


	@PostMapping(value="/ships")
	ResponseEntity<Ship> addOrUpdateShip(@RequestBody Ship ship) {

		logger.debug("\n\naddShip\n\n");

		//PreCondition.checkNotNull("ShipDTO must not be null", ship);
	
		logger.debug("\n\n"+ship.toString()+"\n\n");

		service.addOrUpdateShip(ship);
		
		return new ResponseEntity<Ship>(ship,HttpStatus.OK);
	}


	@DeleteMapping(value="/ships")
	ResponseEntity<String> deleteShips() {

		logger.debug("\n\ndeleteShips\n\n");

		service.deleteShips();
		
		return new ResponseEntity<String>("Ships Deleted",HttpStatus.OK);
	}


	@DeleteMapping(value="/ships/{code}")
	ResponseEntity<String> deleteShip(@PathVariable("code")String code) {

		logger.debug("\n\ndeleteShip\n\n");

		service.deleteShip(code);
		
		return new ResponseEntity<String>("ShipDTO "+code+" Deleted",HttpStatus.OK);
	}


}