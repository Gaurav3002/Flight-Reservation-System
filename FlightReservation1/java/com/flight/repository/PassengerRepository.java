package com.flight.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Passenger;


@Repository
public interface PassengerRepository  extends JpaRepository<Passenger, Long>{

	 
	
}
