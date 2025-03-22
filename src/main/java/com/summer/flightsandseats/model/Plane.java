package com.summer.flightsandseats.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String model;
    private Integer totalRows;
    private Integer seatsPerRow;

    // lowercase "plane" refers to the variable field inside the Seat class
    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)  // plane can have many seats
    private List<Seat> seats;
}
