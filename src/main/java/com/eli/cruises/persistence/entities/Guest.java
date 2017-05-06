package com.eli.cruises.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.eli.cruises.enums.Gender;

@Entity
@Table(name="GUESTS",
	uniqueConstraints={@UniqueConstraint( columnNames = {
			"lastName","firstName","age","gender","address_id"})
	}
)
public class Guest {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@Column(name="lastName",nullable=false)
	@Pattern(regexp="[A-Z][A-Za-z]*",message="last name : only letters allowed")
	@Size(min=2)
	private String lastName;

	@Column(name="firstName",nullable=false)
	@Pattern(regexp="[A-Z][A-Za-z]*",message="first name : only letters allowed")
	@Size(min=2)
	private String firstName;

	@Column(name="age",nullable=false)
	private int age;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender",nullable=false)
	private Gender gender;
	
	@ManyToOne(optional=false,fetch=FetchType.EAGER)
	private Address address;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id 
				+ ", lastName=" + lastName 
				+ ", firstName=" + firstName 
				+ ", age=" + age 
				+ ", gender=" + gender 
				+ ", address=" + address + "]";
	}



	
}
