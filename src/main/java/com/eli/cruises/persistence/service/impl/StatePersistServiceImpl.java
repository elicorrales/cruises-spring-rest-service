package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.cruises.api.dto.StateDTO;
import com.eli.cruises.mappers.impl.StateMapperImpl;
import com.eli.cruises.persistence.entities.State;
import com.eli.cruises.persistence.repository.StateRepository;
import com.eli.cruises.persistence.service.StatePersistService;


@Service
class StatePersistServiceImpl implements StatePersistService {

	private static final Logger logger = LoggerFactory.getLogger(StatePersistServiceImpl.class);
	

	private StateRepository repository;
	
	@Autowired
	StatePersistServiceImpl(StateRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public void deleteStates() {

		repository.deleteAll();
	}

	@Override
	public void deleteState(String name) {

		repository.deleteByName(name);
	}

	@Override
	public List<StateDTO> getStates() {

		return StateMapperImpl.stateEntitiesToStateDtos(repository.findAll());
	}

	@Override
	public List<String> getStateNames() {

		return repository.findAllNames();
	}


	@Override
	public StateDTO addOrUpdateState(StateDTO dto) {

		return StateMapperImpl.stateEntityToStateDto(repository.save(StateMapperImpl.stateDtoToStateEntity(dto)));
	}

	@Override
	public StateDTO getStateById(Long id) {

		return StateMapperImpl.stateEntityToStateDto(repository.findOne(id));
	}

	@Override
	public StateDTO getStateByName(String name) {

		return StateMapperImpl.stateEntityToStateDto(repository.findByName(name));
	}

}
