package com.eli.cruises.api.dto;

public class PaymentDTO {

	private Long id;

	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentDTO [id=" + id + ", amount=" + amount + "]";
	}
	
	
}
