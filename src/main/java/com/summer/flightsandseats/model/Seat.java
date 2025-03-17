package com.summer.flightsandseats.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
    @Id
    private int Id;
}
