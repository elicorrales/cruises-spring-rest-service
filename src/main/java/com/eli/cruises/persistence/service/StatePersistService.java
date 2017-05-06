package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.api.dto.StateDTO;
import com.eli.cruises.persistence.entities.State;


public interface StatePersistService {

	void deleteStates();
	
	void deleteState(String code);
	
	List<StateDTO> getStates();
	
	List<String> getStateNames();

	StateDTO addOrUpdateState(StateDTO state);
	
	StateDTO getStateById(Long id);

	StateDTO getStateByName(String name);
}
