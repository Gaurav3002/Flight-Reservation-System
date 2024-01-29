package com.flight.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.controller.dto.ReservationRequest;
import com.flight.model.Flight;
import com.flight.model.Reservation;
import com.flight.repository.FlightRepository;
import com.flight.service.ReservationService;



@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	@Autowired
	ReservationService service;
	
	Logger LOGGER = LoggerFactory.getLogger(Reservation.class);
//	@GetMapping("/showreservation/{flightId}")
//	public String ShowReservation(@PathVariable("flightId") Long flightId, ModelMap modelmap) {
		
		@GetMapping("/showreservation")
		public String ShowReservation(@RequestParam("flightId") Long flightId, ModelMap modelmap) {
			LOGGER.info("showReservation() invoked with flightId :"+ flightId);
//		flightRepository.findOne(flightId);
		

		Optional<Flight> flight = flightRepository.findById(flightId);
		Flight flight2 = flight.get();
				
		LOGGER.info("Flight is : "+ flight2);
		modelmap.addAttribute("flight", flight2);
		return "completeReservation";
	}
	
	
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelmap) {
//		System.out.println(request.getFlightId());
//		System.out.println(request.getEmail());
		LOGGER.info("CompleteReservation :"+ request);
		Reservation reservation = service.bookFlight(request);
		
		modelmap.addAttribute("msg","Reservation created successfully and the id is "+reservation.getId());
		
		LOGGER.info("Reservation Done");
		
		return"confirmReservation";
	}
}
