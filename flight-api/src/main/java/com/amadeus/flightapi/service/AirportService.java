package com.amadeus.flightapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amadeus.flightapi.exception.DataNotFoundException;
import com.amadeus.flightapi.mapper.AirportMapper;
import com.amadeus.flightapi.model.dto.AirportDto;
import com.amadeus.flightapi.model.entity.Airport;
import com.amadeus.flightapi.model.request.CreateAirportRequest;
import com.amadeus.flightapi.model.request.UpdateAirportRequest;
import com.amadeus.flightapi.repository.AirportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    public List<AirportDto> findAll() {
        return airportMapper.toDtoList(airportRepository.findAll());
    }

    public AirportDto save(CreateAirportRequest createAirportRequest) {
        Airport airport = airportMapper.toEntity(createAirportRequest);
        return airportMapper.toDto(airportRepository.save(airport));
    }

    public void deleteById(Long id) {
        Airport airport = findById(id);
        airportRepository.delete(airport);
    }

    public AirportDto update(Long id, UpdateAirportRequest updateAirportRequest) {
        Airport entity = findById(id);
        entity.setCity(updateAirportRequest.getCity());
        return airportMapper.toDto(airportRepository.save(entity));
    }

    public Airport findById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Airport not found with id: " + id));
    }

    public List<Airport> findByCity(String city){
        return airportRepository.findByCity(city);
    }
}
