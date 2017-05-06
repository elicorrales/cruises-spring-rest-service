package com.eli.cruises.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.Ship;

@Transactional
public interface ShipRepository extends JpaRepository<Ship, Long> {

	Ship findByCode(String code);
	void deleteByCode(String code);
}
