package com.amadeus.flightapi.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "airport")
@Data
public class Airport {
    
    @Id        
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;
}
