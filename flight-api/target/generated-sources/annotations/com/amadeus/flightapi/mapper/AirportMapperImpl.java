package com.amadeus.flightapi.mapper;

import com.amadeus.flightapi.model.dto.AirportDto;
import com.amadeus.flightapi.model.entity.Airport;
import com.amadeus.flightapi.model.request.CreateAirportRequest;
import com.amadeus.flightapi.model.request.UpdateAirportRequest;
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
public class AirportMapperImpl implements AirportMapper {

    @Override
    public Airport toEntity(CreateAirportRequest createAirportRequest) {
        if ( createAirportRequest == null ) {
            return null;
        }

        Airport airport = new Airport();

        airport.setCity( createAirportRequest.getCity() );

        return airport;
    }

    @Override
    public Airport toEntity(UpdateAirportRequest updateAirportRequest) {
        if ( updateAirportRequest == null ) {
            return null;
        }

        Airport airport = new Airport();

        airport.setCity( updateAirportRequest.getCity() );

        return airport;
    }

    @Override
    public AirportDto toDto(Airport airport) {
        if ( airport == null ) {
            return null;
        }

        AirportDto airportDto = new AirportDto();

        airportDto.setId( airport.getId() );
        airportDto.setCity( airport.getCity() );

        return airportDto;
    }

    @Override
    public List<AirportDto> toDtoList(List<Airport> airports) {
        if ( airports == null ) {
            return null;
        }

        List<AirportDto> list = new ArrayList<AirportDto>( airports.size() );
        for ( Airport airport : airports ) {
            list.add( toDto( airport ) );
        }

        return list;
    }
}
