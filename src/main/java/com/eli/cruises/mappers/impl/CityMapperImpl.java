package com.eli.cruises.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.persistence.entities.City;

//right now no need for this, just making it consistent with other mappers
public class CityMapperImpl { //implements CityMapper {

	static public CityDTO cityEntityToCityDto(City entity) {
		CityDTO dto = new CityDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	static public City cityDtoToCityEntity(CityDTO dto) {
		City city = new City();
		city.setId(dto.getId());
		city.setName(dto.getName());
		return city;
	}

	static public List<CityDTO> cityEntitiesToCityDtos(List<City> list) {
		
		List<CityDTO> dtos = new ArrayList<CityDTO>(list.size());
		list.stream().forEach((a)-> {
			dtos.add(cityEntityToCityDto(a));
		});
		return dtos;
	}
}
