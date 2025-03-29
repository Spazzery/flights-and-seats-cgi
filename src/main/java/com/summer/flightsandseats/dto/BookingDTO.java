package com.summer.flightsandseats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class BookingDTO {
    private Integer id;
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private LocalDateTime bookingTime;
    private Integer flightId;
    private List<Integer> seatIds;
}
