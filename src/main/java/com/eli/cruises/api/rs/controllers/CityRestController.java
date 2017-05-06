package com.eli.cruises.api.rs.controllers;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.service.CityPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class CityRestController {

	private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
	
	private CityPersistService service;
	
	
	@Autowired
	CityRestController(CityPersistService service) {
		
		this.service = service;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/cities")
	ResponseEntity<List<CityDTO>> getCities() {

		logger.debug("\n\ngetCities\n\n");

		List<CityDTO> dtos = service.getCities();
		
		return new ResponseEntity<List<CityDTO>>(dtos,HttpStatus.OK);
	}


	@GetMapping(value="/cities/names")
	ResponseEntity<List<String>> getCityNames() {

		logger.debug("\n\ngetCityNames\n\n");

		List<String> cities = service.getCityNames();
		
		try { TimeUnit.MILLISECONDS.sleep(3000); }
		catch (Exception e) {}
		
		return new ResponseEntity<List<String>>(cities,HttpStatus.OK);
	}


	@PostMapping(value="/cities")
	ResponseEntity<CityDTO> addOrUpdateCity(@RequestBody CityDTO dto) {

		logger.debug("\n\naddCity\n\n");

		//PreCondition.checkNotNull("CityDTO must not be null", dto);
	
		logger.debug("\n\n"+dto.toString()+"\n\n");

		dto = service.addOrUpdateCity(dto);
		
		return new ResponseEntity<CityDTO>(dto,HttpStatus.OK);
	}


	@DeleteMapping(value="/cities")
	ResponseEntity<String> deleteCities() {

		logger.debug("\n\ndeleteCities\n\n");

		service.deleteCities();
		
		return new ResponseEntity<String>("Cities Deleted",HttpStatus.OK);
	}


}