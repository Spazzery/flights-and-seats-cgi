package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.model.Seat;
import com.summer.flightsandseats.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    // DI
    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{id}")
    public Optional<Seat> getSeat(@PathVariable Integer id) {
        return seatService.getSeatById(id);
    }

    @PostMapping
    public Seat saveSeat(@RequestBody Seat seat) {
        return seatService.saveSeat(seat);
    }

    @DeleteMapping("/{id}")
    public void deleteSeat(@PathVariable Integer id) {
        seatService.deleteSeat(id);
    }

}
