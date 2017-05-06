package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.persistence.entities.Sailing;


public interface SailingPersistService {

	void deleteSailings();

	List<Sailing> getSailings();
	
	void addOrUpdateSailing(Sailing sailing);
	
}
