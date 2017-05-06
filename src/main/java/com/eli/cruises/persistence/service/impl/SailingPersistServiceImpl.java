package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.Sailing;
import com.eli.cruises.persistence.repository.CruiseRepository;
import com.eli.cruises.persistence.repository.SailingRepository;
import com.eli.cruises.persistence.service.SailingPersistService;


@Service
class SailingPersistServiceImpl implements SailingPersistService {

	private static final Logger logger = LoggerFactory.getLogger(SailingPersistServiceImpl.class);
	

	private SailingRepository repository;
	
	@Autowired
	SailingPersistServiceImpl(
			SailingRepository repository
			) {

		this.repository = repository;
	}

	
	@Override
	public void deleteSailings() {

		repository.deleteAll();
	}

	@Override
	public List<Sailing> getSailings() {

		logger.debug("\n\ngetSailings\n\n");
		List<Sailing> list = repository.findAll();
		//return repository.findAll();
		logger.debug("\n\ngetSailings: returning list\n\n");
		return list;
	}

	@Override
	public void addOrUpdateSailing(Sailing sailing) {

		repository.save(sailing);
	}

}
