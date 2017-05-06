package com.eli.cruises.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.Cruise;

@Transactional
public interface CityRepository extends JpaRepository<City, Long> {

	@Query("SELECT c.name FROM City c")
	List<String> findAllNames();

	City findByName(String name);
}
