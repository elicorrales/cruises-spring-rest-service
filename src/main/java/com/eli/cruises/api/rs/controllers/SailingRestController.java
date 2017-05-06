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

import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.Sailing;
import com.eli.cruises.persistence.service.CruisePersistService;
import com.eli.cruises.persistence.service.SailingPersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class SailingRestController {

	private static final Logger logger = LoggerFactory.getLogger(SailingRestController.class);
	
	private SailingPersistService service;
	private CruisePersistService cruiseService;
	
	
	@Autowired
	SailingRestController(
			SailingPersistService service
			,CruisePersistService cruiseService
			) {
		
		this.service = service;
		this.cruiseService = cruiseService;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/sailings")
	ResponseEntity<List<Sailing>> getSailings() {

		logger.debug("\n\ngetSailings\n\n");

		List<Sailing> sailings = service.getSailings();
		
		logger.debug("\n\ngetSailings: got them, returning\n\n");

		return new ResponseEntity<List<Sailing>>(sailings,HttpStatus.OK);
	}


	@PostMapping(value="/sailings")
	ResponseEntity<Sailing> addOrUpdateSailing(@RequestBody Sailing sailing) {

		logger.debug("\n\naddSailing " + sailing.toString() + "\n\n");

		//PreCondition.checkNotNull("SailingDTO must not be null", sailing);

		//PreCondition.checkNotNull("CruiseDTO must not be null", sailing.getCruise());

		Cruise cruise = sailing.getCruise();
		
		if (cruise.getId()==null && cruise.getCode()!=null) {

			logger.debug("\n\naddSailing : need to get cruise via code \n\n");

			cruise = cruiseService.getCruise(cruise.getCode());
			sailing.setCruise(cruise);
		}

		logger.debug("\n\naddSailing : have cruise : "+cruise.toString()+"\n\n");

		service.addOrUpdateSailing(sailing);
		
		logger.debug("\n\naddSailing : added/updated sailing\n\n");

		return new ResponseEntity<Sailing>(sailing,HttpStatus.OK);
	}


	@DeleteMapping(value="/sailings")
	ResponseEntity<String> deleteSailings() {

		logger.debug("\n\ndeleteSailings\n\n");

		service.deleteSailings();
		
		return new ResponseEntity<String>("Sailings Deleted",HttpStatus.OK);
	}

}