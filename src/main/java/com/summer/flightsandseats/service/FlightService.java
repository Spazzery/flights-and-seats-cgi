package com.summer.flightsandseats.service;

import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor  // Automatically injects dependencies
public class FlightService {

    private final FlightRepository flightRepository;

    // CRUD

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Integer id) {
        return flightRepository.findById(id);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Integer id) {
        flightRepository.deleteById(id);
    }

    // Custom
    // Had ChatGPT generate this - simpler to do in Java rather than JPA SQL or Pure SQL
    public List<Flight> filterFlights(
            String destination,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            Double minPrice,
            Double maxPrice) {
        List<Flight> flights = flightRepository.findAll(); // Get all flights

        return flights.stream()
                .filter(flight -> destination == null || flight.getDestination().equalsIgnoreCase(destination)) // Filter by destination
                .filter(flight -> date == null || flight.getDepartureDate().equals(date)) // Filter by date
                .filter(flight -> startTime == null || flight.getDepartureTime().isAfter(startTime)) // Filter by start time
                .filter(flight -> endTime == null || flight.getDepartureTime().isBefore(endTime)) // Filter by end time
                .filter(flight -> minPrice == null || flight.getPrice() >= minPrice) // Filter by min price
                .filter(flight -> maxPrice == null || flight.getPrice() <= maxPrice) // Filter by max price
                .collect(Collectors.toList()); // Convert back to list
    }
}
