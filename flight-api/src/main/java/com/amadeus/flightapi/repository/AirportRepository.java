package com.amadeus.flightapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amadeus.flightapi.model.entity.Airport;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByCity(String city);
}
