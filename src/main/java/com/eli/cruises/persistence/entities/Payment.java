package com.eli.cruises.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENTS")
public class Payment {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@Column(name="amount",nullable=false)
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
