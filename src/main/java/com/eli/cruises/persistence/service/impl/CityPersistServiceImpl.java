package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.mappers.impl.CityMapperImpl;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.repository.CityRepository;
import com.eli.cruises.persistence.service.CityPersistService;


@Service
class CityPersistServiceImpl implements CityPersistService {

	private static final Logger logger = LoggerFactory.getLogger(CityPersistServiceImpl.class);
	

	private CityRepository repository;
	
	@Autowired
	CityPersistServiceImpl(CityRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public void deleteCities() {

		repository.deleteAll();
	}

	@Override
	@Transactional
	public List<CityDTO> getCities() {

		return CityMapperImpl.cityEntitiesToCityDtos(repository.findAll());
	}


	@Override
	public List<String> getCityNames() {

		return repository.findAllNames();
	}


	@Override
	public CityDTO getCityById(Long id) {

		return CityMapperImpl.cityEntityToCityDto(repository.findOne(id));
	}


	@Override
	public CityDTO getCityByName(String name) {

		return CityMapperImpl.cityEntityToCityDto(repository.findByName(name));
	}


	@Override
	@Transactional
	public CityDTO addOrUpdateCity(CityDTO dto) {

		return CityMapperImpl.cityEntityToCityDto(repository.save(CityMapperImpl.cityDtoToCityEntity(dto)));
	}

}
