package com.eli.cruises.persistence.service;

import java.util.List;

import com.eli.cruises.api.dto.AddressDTO;
import com.eli.cruises.persistence.entities.Address;


public interface AddressPersistService {

	void deleteAddresses();
	
	List<Address> getAddresses();
	
	Address addOrUpdateAddress(Address entity);
	
}
