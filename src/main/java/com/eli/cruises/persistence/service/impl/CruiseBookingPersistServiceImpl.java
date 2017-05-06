package com.eli.cruises.persistence.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eli.cruises.api.dto.CruiseBookingDTO;
import com.eli.cruises.mappers.impl.CruiseBookingMapperImpl;
import com.eli.cruises.persistence.entities.CruiseBooking;
import com.eli.cruises.persistence.entities.GuestBooking;
import com.eli.cruises.persistence.entities.Payment;
import com.eli.cruises.persistence.entities.Sailing;
import com.eli.cruises.persistence.repository.CruiseBookingRepository;
import com.eli.cruises.persistence.repository.GuestBookingRepository;
import com.eli.cruises.persistence.repository.PaymentRepository;
import com.eli.cruises.persistence.repository.SailingRepository;
import com.eli.cruises.persistence.service.CruiseBookingPersistService;


@Service
class CruiseBookingPersistServiceImpl implements CruiseBookingPersistService {

	private static final Logger logger = LoggerFactory.getLogger(CruiseBookingPersistServiceImpl.class);
	

	private CruiseBookingRepository repository;
	private SailingRepository sailingRepository;
	private GuestBookingRepository guestBookingRepository;
	private PaymentRepository paymentRepository;
	
	@Autowired
	CruiseBookingPersistServiceImpl(
			CruiseBookingRepository repository
			,SailingRepository sailingRepository
			,GuestBookingRepository guestBookingRepository
			,PaymentRepository paymentRepository
			) {
		this.repository = repository;
		this.sailingRepository = sailingRepository;
		this.guestBookingRepository = guestBookingRepository;
		this.paymentRepository = paymentRepository;
	}

	
	@Override
	public void deleteCruiseBookings() {

		repository.deleteAll();
	}

	@Override
	//@Transactional
	public List<CruiseBooking> getCruiseBookings() {

		logger.debug("\n\ngetCruiseBookings\n\n");

		return repository.findAll();
	}

	@Override
	@Transactional
	public CruiseBookingDTO addOrUpdateCruiseBooking(CruiseBookingDTO dto) {

		logger.debug("\n\naddOrUpdateCruiseBooking\n\n");

		if (null!=dto) {

			CruiseBooking booking = CruiseBookingMapperImpl.cruiseBookingDtoToCruiseBookingEntity(dto);

			if (null!=booking) {

				Sailing sailing = sailingRepository.getOne(booking.getSailing().getId());

				booking.setSailing(sailing);

				Integer cabinsBooked = booking.getSailing().getCabinsBooked();
				Integer numCabins = booking.getSailing().getCruise().getShip().getNumCabins();
				Integer delta = numCabins - cabinsBooked;
		
				List<GuestBooking> gbks = booking.getGuestBookings();
				if (null!=gbks) {
					for (GuestBooking gbk : gbks) {
						gbk = guestBookingRepository.getOne(gbk.getId());
					}
				}


				Integer qty = gbks.size();
				if (qty>delta) {
					throw new RuntimeException("SailingDTO Can Not Accomodate "
							+ qty + " guests.  Only " + delta + " cabins remain.");
				}

				cabinsBooked += qty;
				booking.getSailing().setCabinsBooked(cabinsBooked);

				List<Payment> payments = booking.getPayments();
				if (null!=payments) {
					for (Payment p : payments) {
						if (p.getId()==null) {
							paymentRepository.save(p);
						}
					}
				}
		
				logger.debug("\n\naddOrUpdateCruiseBooking - final save.... \n\n");
				repository.save(booking);
				logger.debug("\n\naddOrUpdateCruiseBooking - DONE \n\n");
		
				dto = CruiseBookingMapperImpl.cruiseBookingEntityToCruiseBookingDto(booking);
			}
		}
		
		return dto;
	}

}
