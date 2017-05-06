package com.eli.cruises.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.City;
import com.eli.cruises.persistence.entities.Cruise;
import com.eli.cruises.persistence.entities.TempEntity;

@Transactional
public interface TempEntityRepository extends JpaRepository<TempEntity, Long> {

}
