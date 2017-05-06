package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.persistence.entities.Cruise;


public interface CruisePersistService {

	void deleteCruises();

	void deleteCruise(String code);
	
	List<Cruise> getCruises();
	
	void addOrUpdateCruise(Cruise cruise);
	
	Cruise getCruise(String code);
	
}
