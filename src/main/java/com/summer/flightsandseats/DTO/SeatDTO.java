package com.summer.flightsandseats.DTO;

import com.summer.flightsandseats.model.Plane;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class SeatDTO {
    private Integer id;
    private String seatNumber;  // 12
    private String seatLetter;  // E
    private Integer rowNumber;  // 6
    private String seatType;  // Standard, Business
    private boolean isNextToWindow;
    private boolean isNextToAisle;
    private boolean extraLegRoom;
    private boolean isAvailable;
    private PlaneDTO plane;
}
