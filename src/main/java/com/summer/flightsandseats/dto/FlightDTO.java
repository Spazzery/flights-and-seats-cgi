package com.summer.flightsandseats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class FlightDTO {
    private Integer id;
    private String flightNumber;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private Integer duration;
    private Double price;
    private Integer planeId;  // Use an id instead of the full entity
}
