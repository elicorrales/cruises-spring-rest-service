package com.eli.cruises.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.eli.cruises.api.dto.GuestDTO;
import com.eli.cruises.persistence.entities.Guest;

public class GuestMapperImpl { //implements GuestMapper {

	static public List<GuestDTO>  guestEntitiesToGuestDTOs(List<Guest> guests) {
		
		List<GuestDTO> dtos = new ArrayList<GuestDTO>(guests.size());

		guests.stream().forEach((a)->{
			dtos.add(guestEntityToGuestDto(a));
		});
		
		return dtos;
	}

	static public GuestDTO guestEntityToGuestDto(Guest entity) {
		
		GuestDTO dto = null;
		if (null!=entity) {
			dto = new GuestDTO();
			dto.setId(entity.getId());
			dto.setLastName(entity.getLastName());
			dto.setFirstName(entity.getFirstName());
			dto.setAddressDTO(AddressMapperImpl.addressEntityToAddressDto(entity.getAddress()));
			dto.setGender(entity.getGender());
			dto.setAge(entity.getAge());
		}
		return dto;
	}

	static public Guest guestDtoToGuestEntity(GuestDTO dto) {

		Guest guest = null;
		if (null!=dto) {
			guest = new Guest();
			guest.setId(dto.getId());
			guest.setLastName(dto.getLastName());
			guest.setFirstName(dto.getFirstName());
			guest.setAge(dto.getAge());
			guest.setGender(dto.getGender());
			guest.setAddress(AddressMapperImpl.addressDtoToAddressEntity(dto.getAddressDTO()));
		}
		return guest;
	}

}
