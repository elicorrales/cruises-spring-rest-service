package com.eli.cruises.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.Cruise;

@Transactional
public interface CruiseRepository extends JpaRepository<Cruise, Long> {

	Cruise findByCode(String code);
	void deleteByCode(String code);
}
