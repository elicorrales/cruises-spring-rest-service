package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.Ship;


public interface ShipPersistService {

	void deleteShips();
	
	void deleteShip(String code);
	
	List<Ship> getShips();
	
	void addOrUpdateShip(Ship ship);
	
	Ship getShip(String code);
	
}
