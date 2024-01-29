package com.flight.service;

import com.flight.controller.dto.ReservationRequest;
import com.flight.model.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);

}
