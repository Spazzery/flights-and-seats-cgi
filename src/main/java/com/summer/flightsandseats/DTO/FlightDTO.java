package com.summer.flightsandseats.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
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
    private PlaneDTO plane;  // Use a DTO instead of the full entity
}
