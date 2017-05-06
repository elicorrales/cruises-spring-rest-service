package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.repository.CruiseRepository;
import com.eli.cruises.persistence.service.CruisePersistService;


@Service
class CruisePersistServiceImpl implements CruisePersistService {

	private static final Logger logger = LoggerFactory.getLogger(CruisePersistServiceImpl.class);
	

	private CruiseRepository repository;
	
	@Autowired
	CruisePersistServiceImpl(CruiseRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public void deleteCruises() {

		repository.deleteAll();
	}

	@Override
	public void deleteCruise(String code) {

		repository.deleteByCode(code);
	}

	@Override
	public List<Cruise> getCruises() {

		return repository.findAll();
	}

	@Override
	public void addOrUpdateCruise(Cruise cruise) {

		repository.save(cruise);
	}

	@Override
	public Cruise getCruise(String code) {

		return repository.findByCode(code);
	}

}
