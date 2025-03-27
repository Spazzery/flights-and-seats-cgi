package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.dto.FlightDTO;
import com.summer.flightsandseats.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired  // Used for explicit DI, often preferred in controllers. While in service it's done automatically
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<FlightDTO> flights = flightService.getAllFlights();

        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no flights
        }
        return ResponseEntity.ok(flights); // Return 200 with flights
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Integer id) {
        FlightDTO flight = flightService.getFlightById(id);
        if (flight == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlightDTO> saveFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO createdFlight = flightService.saveFlight(flightDTO);
        return new ResponseEntity<>(createdFlight, HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public Flight updateFlight(@PathVariable Integer id, @RequestBody Flight updatedFlight) {
//        return flightService.updateFlight(id, updatedFlight);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Integer id) {
        boolean deleted = flightService.deleteFlight(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Got from ChatGPT, wrote it myself
    @GetMapping("/filter")
    public List<FlightDTO> filter(
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
