package com.summer.flightsandseats.DTO;

import com.summer.flightsandseats.model.Seat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class PlaneDTO {
    private Integer id;
    private String model;
    private Integer totalRows;
    private Integer seatsPerRow;
    private List<SeatDTO> seats;
}
