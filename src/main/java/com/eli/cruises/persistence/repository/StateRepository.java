package com.eli.cruises.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.State;

@Transactional
public interface StateRepository extends JpaRepository<State, Long> {

	@Query("SELECT s.name FROM State s")
	List<String> findAllNames();

	void deleteByName(String name);

	State findByName(String name);
}
