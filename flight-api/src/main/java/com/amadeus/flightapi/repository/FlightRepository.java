package com.amadeus.flightapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amadeus.flightapi.model.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}
