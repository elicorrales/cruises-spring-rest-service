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

import com.eli.cruises.api.dto.StateDTO;
import com.eli.cruises.api.rs.utils.PreCondition;
import com.eli.cruises.persistence.entities.State;
import com.eli.cruises.persistence.service.StatePersistService;


@RestController
@RequestMapping(
		path="/service/rest" 
		//not required.   already handles both.  just put type in client request header
		//,consumes=MediaType.APPLICATION_JSON_VALUE 
		//,produces=MediaType.APPLICATION_JSON_VALUE
		)
class StateRestController {

	private static final Logger logger = LoggerFactory.getLogger(StateRestController.class);
	
	private StatePersistService service;
	
	
	@Autowired
	StateRestController(StatePersistService service) {
		
		this.service = service;
		
		logger.debug("\n\nController\n\n");
	}

	@GetMapping(value="/states")
	ResponseEntity<List<StateDTO>> getStates() {

		logger.debug("\n\ngetStates\n\n");

		List<StateDTO> dtos = service.getStates();
		
		return new ResponseEntity<List<StateDTO>>(dtos,HttpStatus.OK);
	}


	@GetMapping(value="/states/names")
	ResponseEntity<List<String>> getStateNames() {

		logger.debug("\n\ngetStateNames\n\n");

		List<String> states = service.getStateNames();
		
		return new ResponseEntity<List<String>>(states,HttpStatus.OK);
	}

/*
	@GetMapping(value="/states/code/{code}")
	ResponseEntity<State> getStateByCode(@PathVariable("code") String code) {

		logger.debug("\n\ngetStateByCode\n\n");

		State state = PreCondition.checkNotFound("StateDTO "+ code + " not found", service.getStateByCode(code));
		
		return new ResponseEntity<State>(state,HttpStatus.OK);
	}


	@GetMapping(value="/states/name/{name}")
	ResponseEntity<State> getState(@PathVariable("name") String name) {

		logger.debug("\n\ngetStateByName\n\n");

		State state = PreCondition.checkNotFound("StateDTO "+ name + " not found", service.getStateByName(name));
		
		return new ResponseEntity<State>(state,HttpStatus.OK);
	}
*/

	@PostMapping(value="/states")
	ResponseEntity<StateDTO> addOrUpdateState(@RequestBody StateDTO dto) {

		logger.debug("\n\naddState\n\n");

		//PreCondition.checkNotNull("StateDTO must not be null", dto);
	
		logger.debug("\n\n"+dto.toString()+"\n\n");

		dto = service.addOrUpdateState(dto);
		
		return new ResponseEntity<StateDTO>(dto,HttpStatus.OK);
	}


	@DeleteMapping(value="/states")
	ResponseEntity<String> deleteStates() {

		logger.debug("\n\ndeleteStates\n\n");

		service.deleteStates();
		
		return new ResponseEntity<String>("States Deleted",HttpStatus.OK);
	}


	@DeleteMapping(value="/states/{code}")
	ResponseEntity<String> deleteState(@PathVariable("code")String code) {

		logger.debug("\n\ndeleteState\n\n");

		service.deleteState(code);
		
		return new ResponseEntity<String>("StateDTO "+code+" Deleted",HttpStatus.OK);
	}


}