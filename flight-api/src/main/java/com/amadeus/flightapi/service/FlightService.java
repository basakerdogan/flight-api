package com.amadeus.flightapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amadeus.flightapi.exception.DataNotFoundException;
import com.amadeus.flightapi.mapper.FlightMapper;
import com.amadeus.flightapi.model.dto.FlightDto;
import com.amadeus.flightapi.model.entity.Flight;
import com.amadeus.flightapi.model.request.CreateFlightRequest;
import com.amadeus.flightapi.model.request.UpdateFlightRequest;
import com.amadeus.flightapi.repository.FlightRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    public List<FlightDto> findAll() {
        return flightMapper.toDtoList(flightRepository.findAll());
    }

    public FlightDto save(CreateFlightRequest createFlightRequest) {
        Flight flight = flightMapper.toEntity(createFlightRequest);
        return flightMapper.toDto(flightRepository.save(flight));
    }

    public void deleteById(Long id) {
        Flight flight = findById(id);
        flightRepository.delete(flight);
    }

    public FlightDto update(Long id, UpdateFlightRequest updateFlightRequest) {
        Flight entity = findById(id);
        entity.setArrivalAirport(updateFlightRequest.getArrivalAirport());
        entity.setArrivalDateTime(updateFlightRequest.getArrivalDateTime());
        entity.setDepartureAirport(updateFlightRequest.getDepartureAirport());
        entity.setDepartureDateTime(updateFlightRequest.getDepartureDateTime());
        entity.setPrice(updateFlightRequest.getPrice());
        return flightMapper.toDto(flightRepository.save(entity));
    }

    public Flight findById(Long id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Airport not found with id: " + id));
    }
}
