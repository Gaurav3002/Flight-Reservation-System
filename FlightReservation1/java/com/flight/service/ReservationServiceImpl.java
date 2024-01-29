package com.flight.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.controller.dto.ReservationRequest;
import com.flight.model.Flight;
import com.flight.model.Passenger;
import com.flight.model.Reservation;
import com.flight.repository.FlightRepository;
import com.flight.repository.PassengerRepository;
import com.flight.repository.ReservationRepository;
import com.flight.util.EmailUtil;
import com.flight.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailutil;
	
	Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		LOGGER.info("Inside bookFlight()"+request);
		Long flightId = request.getFlightId();
		LOGGER.info("fetching flight for flight detail"+flightId);
		System.out.println(flightId+"*****");
		Optional<Flight> flight = flightRepository.findById(flightId);
		Flight flight2 = flight.get();
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		
		LOGGER.info("Passenger Detail:"+ passenger);
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight2);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		reservation.setCreated(flight2.getEstimatedDepartureTime());
		
		LOGGER.info("Reservation Detail :"+reservation);
		
		Reservation saveR = reservationRepository.save(reservation);
		
		String filepath = "C:\\Users\\gaura\\OneDrive\\Desktop\\reservation\\re";
		LOGGER.info("Generating the itenary");
		pdfGenerator.generateitinerary(saveR, 
				filepath + saveR.getId()+".pdf" );
//		emailutil.sendItinerary(passenger.getEmail(), filepath);
		LOGGER.info("sending the itennary");
		emailutil.sendItinerary(passenger.getEmail());
		LOGGER.info("email send successfully");
		
		
		return saveR;
				
	}
}
