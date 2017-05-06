package com.eli.cruises.mappers.impl;

import com.eli.cruises.api.dto.PaymentDTO;
import com.eli.cruises.api.dto.SailingDTO;
import com.eli.cruises.persistence.entities.Payment;
import com.eli.cruises.persistence.entities.Sailing;

public class SailingMapperImpl { 

	static public SailingDTO sailingEntityToSailingDto(Sailing entity) {

		SailingDTO dto = null;
		if (null!=entity) {
			dto = new SailingDTO();
			dto.setId(entity.getId());
			//dto.setCruise(entity.getCruise());
			dto.setCabinsBooked(entity.getCabinsBooked());
			dto.setYear(entity.getYear());
			dto.setMonth(entity.getMonth());
			dto.setDay(entity.getDay());
		}
		return dto;
	}

	static public Sailing sailingDtoToSailingEntity(SailingDTO dto) {
		
		Sailing sailing = null;
		if (null!=dto) {
			sailing = new Sailing();
			sailing.setId(dto.getId());
			sailing.setCruise(CruiseMapperImpl.cruiseDtoToCruiseEntity(dto.getCruise()));
			sailing.setYear(dto.getYear());
			sailing.setMonth(dto.getMonth());
			sailing.setDay(dto.getDay());
		}
		return sailing;
	}

}
