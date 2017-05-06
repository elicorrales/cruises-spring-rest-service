package com.eli.cruises.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.persistence.entities.GuestBooking;

@Transactional
public interface GuestBookingRepository extends JpaRepository<GuestBooking, Long> {

}
