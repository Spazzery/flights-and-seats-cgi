package com.summer.flightsandseats.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private LocalDateTime bookingTime;

    @ManyToOne  // a booking can be done to one flight, flights can have many bookings
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToMany  // booking can be for many seats and a seat can have multiple bookings
    @JoinTable(
            name = "booking_seat",  // name of the table that was joined together
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;
}
