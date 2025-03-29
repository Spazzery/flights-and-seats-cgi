package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.dto.SeatDTO;
import com.summer.flightsandseats.model.Seat;
import com.summer.flightsandseats.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    // Dependency Injection
    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public ResponseEntity<List<SeatDTO>> getAllSeats() {
        List<SeatDTO> seats = seatService.getAllSeats();

        if (seats.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no seats
        }
        return ResponseEntity.ok(seats); // Return 200 with seat list
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatDTO> getSeatById(@PathVariable Integer id) {
        SeatDTO seat = seatService.getSeatById(id);

        if (seat == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SeatDTO> saveSeat(@RequestBody SeatDTO seatDTO) {
        SeatDTO createdSeat = seatService.saveSeat(seatDTO);
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable Integer id) {
        boolean deleted = seatService.deleteSeat(id);

        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
