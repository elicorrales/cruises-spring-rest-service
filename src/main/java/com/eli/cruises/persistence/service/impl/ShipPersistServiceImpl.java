package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.Ship;
import com.eli.cruises.persistence.repository.CruiseRepository;
import com.eli.cruises.persistence.repository.ShipRepository;
import com.eli.cruises.persistence.service.CruisePersistService;
import com.eli.cruises.persistence.service.ShipPersistService;


@Service
class ShipPersistServiceImpl implements ShipPersistService {

	private static final Logger logger = LoggerFactory.getLogger(ShipPersistServiceImpl.class);
	

	private ShipRepository repository;
	
	@Autowired
	ShipPersistServiceImpl(ShipRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public void deleteShips() {

		repository.deleteAll();
	}

	@Override
	public void deleteShip(String code) {

		repository.deleteByCode(code);
	}

	@Override
	public List<Ship> getShips() {

		return repository.findAll();
	}

	@Override
	public void addOrUpdateShip(Ship cruise) {

		repository.save(cruise);
	}

	@Override
	public Ship getShip(String code) {

		return repository.findByCode(code);
	}

}
