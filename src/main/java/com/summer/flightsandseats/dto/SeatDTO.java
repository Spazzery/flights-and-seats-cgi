package com.summer.flightsandseats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
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
    private Integer planeId;
}
