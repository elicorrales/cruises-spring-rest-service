package com.eli.cruises.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eli.cruises.api.dto.AddressDTO;
import com.eli.cruises.persistence.entities.Address;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.State;

public class AddressMapperImpl { //implements AddressMapper {

	private static final Logger logger = LoggerFactory.getLogger(AddressMapperImpl.class);
	
	static public List<AddressDTO> addressEntitiesToAddressDTOs(List<Address> entities) {
		
		List<AddressDTO> dtos = new ArrayList<AddressDTO>(entities.size());
	
		entities.stream().forEach((a)->{
			AddressDTO dto = addressEntityToAddressDto(a);
			dtos.add(dto);
		});
	
		return dtos;
	}
	
	
	static public List<Long> addressEntitiesToAddressIds(List<Address> entities) {
		
		List<Long> dtos = new ArrayList<Long>(entities.size());
	
		for (Address a : entities) {
			dtos.add(a.getId());
		}
		
		return dtos;
	}
	
	
	static public AddressDTO addressEntityToAddressDto(Address entity) {
		AddressDTO dto = null;
		if (entity!=null) {
			dto = new AddressDTO();
			dto.setId(entity.getId());
			dto.setAddress1(entity.getAddress1());
			dto.setAddress2(entity.getAddress2());
			dto.setCityName(entity.getCity().getName());
			dto.setStateName(entity.getState().getName());
			dto.setZip(entity.getZip());
		}
		return dto;
	}

	//@Override
	static public Address addressDtoToAddressEntity(AddressDTO dto) {

		logger.debug("\n\nmapper: dto: " + dto + "\n\n");
	
		Address address = null;
		if (null!=dto) {
			address = new Address();
			address.setId(dto.getId());
			City city = new City();
			city.setName(dto.getCityName());
			State state = new State();
			state.setName(dto.getStateName());
			address.setAddress1(dto.getAddress1());
			address.setAddress2(dto.getAddress2());
			address.setCity(city);
			address.setState(state);
			address.setZip(dto.getZip());
		}

		logger.debug("\n\nmapper: address: " + address + "\n\n");

		return address;
	}

}
