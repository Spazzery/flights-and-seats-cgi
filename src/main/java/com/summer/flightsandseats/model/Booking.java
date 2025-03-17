package com.summer.flightsandseats.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Booking {
    @Id
    private int Id;
}
