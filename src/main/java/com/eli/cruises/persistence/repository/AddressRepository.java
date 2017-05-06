package com.eli.cruises.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.Address;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {

}
