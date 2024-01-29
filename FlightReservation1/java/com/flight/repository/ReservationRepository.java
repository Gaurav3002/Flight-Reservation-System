package com.flight.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flight.model.Reservation;


@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long>{

	 
	
}
