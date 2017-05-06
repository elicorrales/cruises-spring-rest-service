package com.eli.cruises.api.dto;

import com.eli.cruises.enums.Gender;

public class GuestDTO {

	private Long id;

	private String lastName;

	private String firstName;

	private int age;
	
	private Gender gender;
	
	private AddressDTO addressDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	@Override
	public String toString() {
		return "GuestDTO [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + ", gender="
				+ gender + ", addressDTO=" + addressDTO + "]";
	}



	
}
