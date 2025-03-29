package com.summer.flightsandseats.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class PlaneDTO {
    private Integer id;
    private String model;
    private Integer totalRows;
    private Integer seatsPerRow;
    private List<Integer> seatIds;
}
