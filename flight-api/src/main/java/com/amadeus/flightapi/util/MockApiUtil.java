package com.amadeus.flightapi.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.amadeus.flightapi.model.request.CreateFlightRequest;

@Component
public class MockApiUtil {
    
    public static CreateFlightRequest generateMockFlightInfo() {
        CreateFlightRequest mockFlightInfo = new CreateFlightRequest();
        mockFlightInfo.setArrivalAirport("Ankara");
        mockFlightInfo.setArrivalDateTime(LocalDateTime.now());
        mockFlightInfo.setDepartureAirport("Samsun");
        mockFlightInfo.setDepartureDateTime(LocalDateTime.now().minusHours(1));
        mockFlightInfo.setPrice(1000L);
        return mockFlightInfo;
    }
}
