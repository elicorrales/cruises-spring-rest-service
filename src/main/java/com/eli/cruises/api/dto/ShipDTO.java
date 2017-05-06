package com.eli.cruises.api.dto;

import com.eli.cruises.enums.ShipStatus;

public class ShipDTO {

	private Long id;

	private String code;
	
	private String name;

	private String description;
	
	private Integer numCabins;

	private ShipStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNumCabins() {
		return numCabins;
	}

	public void setNumCabins(Integer numCabins) {
		this.numCabins = numCabins;
	}

	public ShipStatus getStatus() {
		return status;
	}

	public void setStatus(ShipStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ShipDTO [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + ", numCabins="
				+ numCabins + ", status=" + status + "]";
	}


	
}
