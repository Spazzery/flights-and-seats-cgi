package com.summer.flightsandseats.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {
    @Id
    private int Id;
}
