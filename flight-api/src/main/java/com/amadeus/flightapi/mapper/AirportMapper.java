package com.amadeus.flightapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.amadeus.flightapi.model.dto.AirportDto;
import com.amadeus.flightapi.model.entity.Airport;
import com.amadeus.flightapi.model.request.CreateAirportRequest;
import com.amadeus.flightapi.model.request.UpdateAirportRequest;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    Airport toEntity(CreateAirportRequest createAirportRequest);

    Airport toEntity(UpdateAirportRequest updateAirportRequest);

    AirportDto toDto(Airport airport);

    List<AirportDto> toDtoList(List<Airport> airports);
    
}
