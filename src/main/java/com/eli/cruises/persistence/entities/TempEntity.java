package com.eli.cruises.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TEMP")
public class TempEntity {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;

	@ElementCollection
	@Column(name="someValues",nullable=false,unique=true)
	private List<String> someValues;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getSomeValues() {
		return someValues;
	}

	public void setSomeValues(List<String> someValues) {
		this.someValues = someValues;
	}

	@Override
	public String toString() {
		return "TempEntity [id=" + id + ", someValues=" + someValues + "]";
	}


}
