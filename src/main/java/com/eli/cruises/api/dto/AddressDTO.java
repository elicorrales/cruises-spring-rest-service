package com.eli.cruises.api.dto;

public class AddressDTO {

	private Long id;

	private String address1;

	private String address2;
	
	private String cityName;
	
	private String  stateName;
	
	private String zip;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", address1=" + address1 + ", address2=" + address2 + ", cityName=" + cityName + ", stateName="
				+ stateName + ", zip=" + zip + "]";
	}
	
	
}
