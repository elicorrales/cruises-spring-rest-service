package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.persistence.entities.Address;
import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.TempEntity;


public interface TempEntityPersistService {

	void deleteTempEntities();

	List<TempEntity> getTempEntities();
	
	void addOrUpdateTempEntity(TempEntity entity);
	
}
