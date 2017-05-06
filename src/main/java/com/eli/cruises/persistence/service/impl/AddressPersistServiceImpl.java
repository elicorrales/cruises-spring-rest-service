package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.api.dto.AddressDTO;
import com.eli.cruises.api.dto.CityDTO;
import com.eli.cruises.api.dto.StateDTO;
import com.eli.cruises.mappers.impl.AddressMapperImpl;
import com.eli.cruises.persistence.entities.Address;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.State;
import com.eli.cruises.persistence.repository.AddressRepository;
import com.eli.cruises.persistence.repository.CityRepository;
import com.eli.cruises.persistence.repository.StateRepository;
import com.eli.cruises.persistence.service.AddressPersistService;
import com.eli.cruises.persistence.service.CityPersistService;
import com.eli.cruises.persistence.service.StatePersistService;


@Service
class AddressPersistServiceImpl implements AddressPersistService {

	private static final Logger logger = LoggerFactory.getLogger(AddressPersistServiceImpl.class);
	

	private AddressRepository repository;
	private CityRepository cityRepository;
	private StateRepository stateRepository;
	
	@Autowired
	AddressPersistServiceImpl(
			AddressRepository repository
			,CityRepository cityRepository
			,StateRepository stateRepository
			) {
		this.repository = repository;
		this.cityRepository = cityRepository;
		this.stateRepository = stateRepository;
	}

	@Override
	@Transactional
	public Address addOrUpdateAddress(Address address) {

		logger.debug("\n\naddOrUpdateAddresses " + address + "\n\n");

		if (null!=address) {
		
			if (address.getCity().getId()==null) {

				City city = cityRepository.findByName(address.getCity().getName());
			
				address.setCity(city);
			}

			if (address.getState().getId()==null) {
	
				State state = stateRepository.findByName(address.getState().getName());
			
				address.setState(state);
			}

		}
		
		return repository.save(address);
	}

	@Override
	public void deleteAddresses() {
		repository.deleteAll();
	}

	@Override
	//@Transactional
	public List<Address> getAddresses() {

		logger.debug("\n\ngetAddresses\n\n");

		return repository.findAll();
	}


}
