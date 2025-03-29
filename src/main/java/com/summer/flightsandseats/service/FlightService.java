package com.summer.flightsandseats.service;

import com.summer.flightsandseats.dto.FlightDTO;
import com.summer.flightsandseats.mapper.FlightMapper;
import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.repository.FlightRepository;
import com.summer.flightsandseats.specification.FlightSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor  // Automatically injects dependencies
public class FlightService {

    private final FlightRepository flightRepository;

    // CRUD

    public List<FlightDTO> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return FlightMapper.INSTANCE.toDTOList(flights);
    }

    public FlightDTO getFlightById(Integer id) {
        Flight flight = flightRepository.findById(id).orElse(null);
        return flight != null ? FlightMapper.INSTANCE.toDto(flight) : null;
    }

    public FlightDTO saveFlight(FlightDTO flightDTO) {
        Flight flight = FlightMapper.INSTANCE.toEntity(flightDTO);
        Flight savedFlight = flightRepository.save(flight);
        return FlightMapper.INSTANCE.toDto(savedFlight);
    }

    public boolean deleteFlight(Integer id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Custom
    // Had Gemini generate this
    // here I will create a database query that retrieves only needed flights
    public List<FlightDTO> filterFlights(
            String destination,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            Double minPrice,
            Double maxPrice) {
        List<Flight> flights = flightRepository.findAll(FlightSpecifications.filterFlights(
                destination,
                date,
                startTime,
                endTime,
                minPrice,
                maxPrice
        ));

        return flights.stream()
                .map(FlightMapper.INSTANCE::toDto)
                .collect(Collectors.toList()); // Convert back to list
    }
}
