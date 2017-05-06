package com.eli.cruises.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.api.dto.StateDTO;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.State;

//right now no need for this, just making it consistent with other mappers
public class StateMapperImpl { 

	static public StateDTO stateEntityToStateDto(State entity) {
		StateDTO dto = new StateDTO();
		dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}

	static public State stateDtoToStateEntity(StateDTO dto) {
		State entity = new State();
		entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

	static public List<StateDTO> stateEntitiesToStateDtos(List<State> list) {
		
		List<StateDTO> dtos = new ArrayList<StateDTO>(list.size());
		list.stream().forEach((a)-> {
			dtos.add(stateEntityToStateDto(a));
		});
		return dtos;
	}
}
