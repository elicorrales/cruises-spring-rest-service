package com.eli.cruises.api.dto;

public class SailingDTO {

	private Long id;

	private CruiseDTO cruise;
	
	private Long year;

	private Long month;

	private Long day;

	private Integer cabinsBooked;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CruiseDTO getCruise() {
		return cruise;
	}

	public void setCruise(CruiseDTO cruise) {
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
