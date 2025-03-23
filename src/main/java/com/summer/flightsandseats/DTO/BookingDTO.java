package com.summer.flightsandseats.DTO;

import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.model.Seat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDTO {
    private Integer id;
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private LocalDateTime bookingTime;
    private FlightDTO flight;
    private List<SeatDTO> seats;
}
