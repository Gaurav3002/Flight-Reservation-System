package com.flight.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.controller.dto.ReservationUpdateRequest;
import com.flight.model.Reservation;
import com.flight.repository.ReservationRepository;

//in order to angular communicte our rest app we need to turn on the cross origin header
@RestController
@CrossOrigin

public class ReservationRestController {
	
	@Autowired
	ReservationRepository reservationRepository;
	Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);
	
	@GetMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id : "+ id);
		Optional<Reservation> find = reservationRepository.findById(id);
		return find.get();
	}
	
	
	@PostMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updatReservation() for " +request);
		Optional<Reservation> byId = reservationRepository.findById(request.getId());
		Reservation reservation = byId.get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation");
		return reservationRepository.save(reservation);
		
	}

} 
