package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired  // Used for explicit DI, often preferred in controllers. While in service it's done automatically
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Optional<Flight> getFlightById(@PathVariable Integer id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    public Flight saveFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

//    @PutMapping("/{id}")
//    public Flight updateFlight(@PathVariable Integer id, @RequestBody Flight updatedFlight) {
//        return flightService.updateFlight(id, updatedFlight);
//    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Integer id) {
        flightService.deleteFlight(id);
    }

    // Got from ChatGPT, wrote it myself
    @GetMapping("/filter")
    public List<Flight> filter(
            @RequestParam(required = false) String destination,
            @RequestParam(required = false) LocalDate date,
            @RequestParam(required = false) LocalTime startTime,
            @RequestParam(required = false) LocalTime endTime,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
            ) {
        return flightService.filterFlights(destination, date, startTime, endTime, minPrice, maxPrice);
    }

}
