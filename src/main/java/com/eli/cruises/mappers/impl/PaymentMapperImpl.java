package com.eli.cruises.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import com.eli.cruises.api.dto.PaymentDTO;
import com.eli.cruises.persistence.entities.Payment;

public class PaymentMapperImpl { 

	static public List<Long> paymentEntitiesToPaymentIds(List<Payment> entities) {

		List<Long> ids = new ArrayList<Long>(entities.size());
		entities.stream().forEach(a -> { ids.add(a.getId()); });
		return ids;
	}

	static public List<Payment> paymentDtosToPaymentEntities(List<PaymentDTO> dtos) {
		
		List<Payment> entities = new ArrayList<Payment>(dtos.size());
		dtos.stream().forEach(a -> { entities.add(paymentDtoToPaymentEntity(a)); });
		return entities;
	}

	static public List<PaymentDTO> paymentEntitiesToPaymentDtos(List<Payment> entities) {
		
		List<PaymentDTO> dtos = new ArrayList<PaymentDTO>(entities.size());
		entities.stream().forEach(a -> { dtos.add(paymentEntityToPaymentDto(a)); });
		return dtos;
	}

	static public PaymentDTO paymentEntityToPaymentDto(Payment payment) {
		
		PaymentDTO dto = new PaymentDTO();
		dto.setId(payment.getId());
		dto.setAmount(payment.getAmount());
		return dto;
	}
	
	
	static public Payment paymentDtoToPaymentEntity(PaymentDTO dto) {
		
		Payment payment = new Payment();
		payment.setId(dto.getId());
		payment.setAmount(dto.getAmount());
		return payment;
	}

}
