package com.amadeus.flightapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.flightapi.model.dto.FlightDto;
import com.amadeus.flightapi.model.request.CreateFlightRequest;
import com.amadeus.flightapi.model.request.UpdateFlightRequest;
import com.amadeus.flightapi.service.FlightService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/flight/")
@RestController
public class FlightController {

    private final FlightService flightService;

    @ApiOperation(value = "Get Flights")
    @GetMapping
    public ResponseEntity<List<FlightDto>> findAll() {
        return ResponseEntity.ok(flightService.findAll());
    }

    @ApiOperation(value = "Save Flight")
    @PostMapping
    public ResponseEntity<FlightDto> save(@RequestBody CreateFlightRequest createFlightRequest) {
        return ResponseEntity.ok(flightService.save(createFlightRequest));
    }

    @ApiOperation(value = "Delete Flight")
    @DeleteMapping("{id}")
    public void deleteRule(@PathVariable Long id) {
        flightService.deleteById(id);
    }

    @ApiOperation(value = "Update Flight")
    @PutMapping("{id}")
    public ResponseEntity<FlightDto> updateRule(@PathVariable Long id,
            @Valid @RequestBody UpdateFlightRequest updateRequest) {
        return ResponseEntity.ok(flightService.update(id, updateRequest));

    }
}
