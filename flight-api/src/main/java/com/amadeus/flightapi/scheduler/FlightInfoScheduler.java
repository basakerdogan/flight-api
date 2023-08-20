package com.amadeus.flightapi.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amadeus.flightapi.model.dto.FlightDto;
import com.amadeus.flightapi.model.request.CreateFlightRequest;
import com.amadeus.flightapi.service.FlightService;
import com.amadeus.flightapi.util.MockApiUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Component
public class FlightInfoScheduler {

    private final FlightService flightService;


    @Scheduled(cron = "0 0 0 * * *") // At 00:00:00am every day
    public void fetchAndSaveFlightInfo() {
        log.info("scheduler started");
        CreateFlightRequest createFlightRequest = MockApiUtil.generateMockFlightInfo();
        FlightDto flight = flightService.save(createFlightRequest);
        log.info("Flight " + flight.getId() + " is saved");
    }
}
