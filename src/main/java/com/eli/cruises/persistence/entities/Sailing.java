package com.eli.cruises.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="SAILINGS",
uniqueConstraints={ @UniqueConstraint(columnNames = {
		"cruise_id", "year","month","day"})
})
public class Sailing {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@OneToOne(optional=false,fetch=FetchType.EAGER)
	private Cruise cruise;
	
	@Column(name="year",nullable=false)
	private Long year;

	@Column(name="month",nullable=false)
	private Long month;

	@Column(name="day",nullable=false)
	private Long day;

	@Column(name="cabinsBooked",nullable=false)
	private Integer cabinsBooked;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cruise getCruise() {
		return cruise;
	}

	public void setCruise(Cruise cruise) {
		this.cruise = cruise;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getDay() {
		return day;
	}

	public void setDay(Long day) {
		this.day = day;
	}

	public Integer getCabinsBooked() {
		return cabinsBooked;
	}

	public void setCabinsBooked(Integer cabinsBooked) {
		this.cabinsBooked = cabinsBooked;
	}

	@Override
	public String toString() {
		return "SailingDTO [id=" + id 
				+ ", cruise=" + cruise 
				+ ", year=" + year 
				+ ", month=" + month 
				+ ", day=" + day
				+ ", cabinsBooked=" + cabinsBooked
				+ "]";
	}

	

}
