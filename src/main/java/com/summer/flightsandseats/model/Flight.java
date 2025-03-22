package com.summer.flightsandseats.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Data  // generate getters/setters, toString, toHashCode and equals etc
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String flightNumber;
    private String destination;

    private LocalDate departureDate;
    private LocalTime departureTime;

    private LocalDate arrivalDate;
    private LocalTime arrivalTime;

    private Integer duration;

    private Double price;


    @ManyToOne  // differents flights can have same airplane
    @JoinColumn(name = "plane_id")  // adds a foreign key plane_id to table "flight"
    private Plane plane;
}
