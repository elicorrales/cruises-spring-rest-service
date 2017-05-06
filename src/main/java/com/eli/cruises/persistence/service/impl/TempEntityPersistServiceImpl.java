package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eli.cruises.persistence.entities.TempEntity;
import com.eli.cruises.persistence.repository.TempEntityRepository;
import com.eli.cruises.persistence.service.TempEntityPersistService;


@Service
class TempEntityPersistServiceImpl implements TempEntityPersistService {

	private static final Logger logger = LoggerFactory.getLogger(TempEntityPersistServiceImpl.class);
	

	private TempEntityRepository repository;
	
	@Autowired
	TempEntityPersistServiceImpl(TempEntityRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public void deleteTempEntities() {

		repository.deleteAll();
	}

	@Override
	public List<TempEntity> getTempEntities() {

		return repository.findAll();
	}

	@Override
	public void addOrUpdateTempEntity(TempEntity entity) {

		repository.save(entity);
	}

}
