package com.flight.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.model.Flight;
import com.flight.repository.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);
	
	@PostMapping("findFlights")
//	public String findFlight(@RequestParam("departureCity") String from, @RequestParam("arrivalCity") String to,
//			@RequestParam("dateOfDeparture")@DateTimeFormat Date dateOfDeparture,
//			ModelMap modelmap) {
		
	
		public String findFlight(@RequestParam("departureCity") String from, @RequestParam("arrivalCity") String to,
				ModelMap modelmap) {
		
		LOGGER.info("Inside findflight()"+from+" TO "+to);
//		List<Flight> flights = flightRepository.findFlights(from,to,dateOfDeparture);
		List<Flight> flights = flightRepository.findFlights(from,to);
		
		
		modelmap.addAttribute("flights", flights);
		LOGGER.info("Flight found are :" +flights);
		
		return "displayFlights";
		
	}

	
	@GetMapping("admin/showAddFlight")
	 public String ShowAddFlight() {
		
		
		return "addFlight";	 
	 }
	
	@PostMapping("admin/addFlight")
	public String AddFlight( @ModelAttribute Flight flight) {
		flightRepository.save(flight);
		 
		
		return "";
	}
	
	
}
