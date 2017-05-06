package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.api.dto.AddressDTO;
import com.eli.cruises.api.dto.GuestDTO;
import com.eli.cruises.mappers.impl.AddressMapperImpl;
import com.eli.cruises.mappers.impl.GuestMapperImpl;
import com.eli.cruises.persistence.entities.Address;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.Guest;
import com.eli.cruises.persistence.entities.State;
import com.eli.cruises.persistence.repository.AddressRepository;
import com.eli.cruises.persistence.repository.CityRepository;
import com.eli.cruises.persistence.repository.GuestRepository;
import com.eli.cruises.persistence.repository.StateRepository;
import com.eli.cruises.persistence.service.AddressPersistService;
import com.eli.cruises.persistence.service.CityPersistService;
import com.eli.cruises.persistence.service.GuestPersistService;
import com.eli.cruises.persistence.service.StatePersistService;


@Service
class GuestPersistServiceImpl implements GuestPersistService {

	private static final Logger logger = LoggerFactory.getLogger(GuestPersistServiceImpl.class);
	

	private GuestRepository repository;
	private AddressPersistService  addressService;
	//private AddressRepository adrRepository;
	//private CityPersistService cityService;
	//private StatePersistService stateService;
	
	
	@Autowired
	GuestPersistServiceImpl(
			GuestRepository repository
			,AddressPersistService addressService
			//,AddressRepository adrRepository
			//,CityPersistService cityService
			//,StatePersistService stateService
			) {

		this.repository = repository;
		this.addressService = addressService;
		//this.adrRepository = adrRepository;
		//this.cityService = cityService;
		//this.stateService = stateService;
	}

	
	@Override
	public void deleteGuests() {

		repository.deleteAll();
	}

	@Override
	@Transactional
	public List<GuestDTO> getGuests() {

		List<Guest> list = repository.findAll();
		return GuestMapperImpl.guestEntitiesToGuestDTOs(list);
	}

	@Override
	@Transactional
	/**
	 * save new or update existing guest info, and this includes saving / updating the address.
	 */
	public GuestDTO addOrUpdateGuest(GuestDTO dto) {

		logger.debug("\n\naddOrUpdateGuest dto : " + dto + "\n\n");
		
		// new addresses will have no id --> means save
		// addresses with id --> means upate.   however,
		// it is possible the address(id) to be updated might have null REQUIRED fields
		// but try/catch here doesn't work - exception is handled earlier.
		// 
		// sooo.... existing address info must contain all required fields, or the
		// entire transaction fails.
		
		Guest entity = GuestMapperImpl.guestDtoToGuestEntity(dto);

		logger.debug("\n\naddOrUpdateGuest entity : " + entity + "\n\n");

		Address address = addressService.addOrUpdateAddress(entity.getAddress());

		logger.debug("\n\naddOrUpdateGuest address : " + address + "\n\n");

		entity.setAddress(address);

		entity = repository.save(entity);

		logger.debug("\n\naddOrUpdateGuest SAVED entity : " + entity + "\n\n");

		return GuestMapperImpl.guestEntityToGuestDto(entity);
	}

}
