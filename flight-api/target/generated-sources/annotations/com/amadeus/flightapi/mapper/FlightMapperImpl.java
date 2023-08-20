package com.amadeus.flightapi.mapper;

import com.amadeus.flightapi.model.dto.FlightDto;
import com.amadeus.flightapi.model.entity.Flight;
import com.amadeus.flightapi.model.request.CreateFlightRequest;
import com.amadeus.flightapi.model.request.UpdateFlightRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T11:36:11+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class FlightMapperImpl implements FlightMapper {

    @Override
    public Flight toEntity(CreateFlightRequest createFlightRequest) {
        if ( createFlightRequest == null ) {
            return null;
        }

        Flight flight = new Flight();

        flight.setDepartureAirport( createFlightRequest.getDepartureAirport() );
        flight.setArrivalAirport( createFlightRequest.getArrivalAirport() );
        flight.setDepartureDateTime( createFlightRequest.getDepartureDateTime() );
        flight.setArrivalDateTime( createFlightRequest.getArrivalDateTime() );
        flight.setPrice( createFlightRequest.getPrice() );

        return flight;
    }

    @Override
    public Flight toEntity(UpdateFlightRequest updateFlightRequest) {
        if ( updateFlightRequest == null ) {
            return null;
        }

        Flight flight = new Flight();

        flight.setDepartureAirport( updateFlightRequest.getDepartureAirport() );
        flight.setArrivalAirport( updateFlightRequest.getArrivalAirport() );
        flight.setDepartureDateTime( updateFlightRequest.getDepartureDateTime() );
        flight.setArrivalDateTime( updateFlightRequest.getArrivalDateTime() );
        flight.setPrice( updateFlightRequest.getPrice() );

        return flight;
    }

    @Override
    public FlightDto toDto(Flight flight) {
        if ( flight == null ) {
            return null;
        }

        FlightDto flightDto = new FlightDto();

        flightDto.setId( flight.getId() );
        flightDto.setDepartureAirport( flight.getDepartureAirport() );
        flightDto.setArrivalAirport( flight.getArrivalAirport() );
        flightDto.setDepartureDateTime( flight.getDepartureDateTime() );
        flightDto.setArrivalDateTime( flight.getArrivalDateTime() );
        flightDto.setPrice( flight.getPrice() );

        return flightDto;
    }

    @Override
    public List<FlightDto> toDtoList(List<Flight> flights) {
        if ( flights == null ) {
            return null;
        }

        List<FlightDto> list = new ArrayList<FlightDto>( flights.size() );
        for ( Flight flight : flights ) {
            list.add( toDto( flight ) );
        }

        return list;
    }
}
