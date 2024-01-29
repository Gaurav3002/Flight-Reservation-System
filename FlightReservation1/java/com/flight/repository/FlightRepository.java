package com.flight.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.model.Flight;


@Repository
public interface FlightRepository  extends JpaRepository<Flight, Long>{

//	here spring data jpa will generate query as Select * from Flight where fight.from
//	then bind those quary parameter with the parameter using @param annotaion
//	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
//	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,
//			@Param("dateOfDeparture") Date dateOfDeparture);
//	
	@Query("from Flight where departureCity=:departureCity and arrivalCity=:arrivalCity")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to);



	 
	
}
