package com.eli.cruises.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.Sailing;

@Transactional
public interface SailingRepository extends JpaRepository<Sailing, Long> {

}
