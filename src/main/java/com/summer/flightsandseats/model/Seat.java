package com.summer.flightsandseats.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String seatNumber;  // 12
    private String seatLetter;  // E
    private Integer rowNumber;  // 6

    private String seatType;  // Standard, Business

    // Extra classifiers
    private boolean isNextToWindow;
    private boolean isNextToAisle;
    private boolean extraLegRoom;
    private boolean isAvailable;

    @ManyToOne  // a seat can only be in one airplane
    @JoinColumn(name = "plane_id")  // This column is in the Seat table, not the Plane table
    private Plane plane;

}
