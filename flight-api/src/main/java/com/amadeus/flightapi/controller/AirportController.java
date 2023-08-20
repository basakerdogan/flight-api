package com.amadeus.flightapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.amadeus.flightapi.model.entity.Airport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.flightapi.model.dto.AirportDto;
import com.amadeus.flightapi.model.request.CreateAirportRequest;
import com.amadeus.flightapi.model.request.UpdateAirportRequest;
import com.amadeus.flightapi.service.AirportService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/airport/")
@RestController
public class AirportController {

    private final AirportService airportService;

    @ApiOperation(value = "Get Airports")
    @GetMapping
    public List<AirportDto> findAll() {
        return airportService.findAll();
    }

    @ApiOperation(value = "Save Airport")
    @PostMapping
    public AirportDto save(@RequestBody CreateAirportRequest createAirportRequest) {
        return airportService.save(createAirportRequest);
    }

    @ApiOperation(value = "Delete Airport")
    @DeleteMapping("{id}")
    public void deleteRule(@PathVariable Long id) {
        airportService.deleteById(id);
    }

    @ApiOperation(value = "Update Airport")
    @PutMapping("{id}")
    public ResponseEntity<AirportDto> updateRule(@PathVariable Long id,
            @Valid @RequestBody UpdateAirportRequest updateRequest) {
        return ResponseEntity.ok(airportService.update(id, updateRequest));

    }

    @GetMapping("{city}")
    public ResponseEntity<List<Airport>> findByCity(@PathVariable String city){
        return ResponseEntity.ok(airportService.findByCity(city));
    }

}
