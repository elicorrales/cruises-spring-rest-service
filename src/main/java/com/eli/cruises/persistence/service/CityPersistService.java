package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.persistence.entities.Address;
import com.eli.cruises.persistence.entities.City;


public interface CityPersistService {

	void deleteCities();

	List<CityDTO> getCities();

	List<String> getCityNames();
	
	CityDTO getCityById(Long id);
	CityDTO getCityByName(String name);

	CityDTO addOrUpdateCity(CityDTO dto);
	
}
