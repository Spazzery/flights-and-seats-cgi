package com.summer.flightsandseats.dto;

import com.summer.flightsandseats.model.Plane;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

// unused right now
@Data
public class FullFlightDTO {
    private Integer id;
    private String flightNumber;
    private String destination;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private Integer duration;
    private Double price;
    private Plane plane;  // Use an id instead of the full entity
}
