package com.amadeus.flightapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.amadeus.flightapi.model.dto.FlightDto;
import com.amadeus.flightapi.model.entity.Flight;
import com.amadeus.flightapi.model.request.CreateFlightRequest;
import com.amadeus.flightapi.model.request.UpdateFlightRequest;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    
    Flight toEntity(CreateFlightRequest createFlightRequest);

    Flight toEntity(UpdateFlightRequest updateFlightRequest);

    FlightDto toDto(Flight flight);

    List<FlightDto> toDtoList(List<Flight> flights);

}
