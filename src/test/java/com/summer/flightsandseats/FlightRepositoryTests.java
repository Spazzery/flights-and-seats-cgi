package com.summer.flightsandseats;

import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    void testCreateFlight() {
        Flight flight = new Flight();
        flight.setId(1);
        flight.setFlightNumber("A235-JPTLN");

        Flight savedFlight = flightRepository.save(flight);

        assertNotNull(savedFlight);
        assertNotNull(savedFlight.getId()); // Verify the ID is generated
        assertEquals("A235-JPTLN", savedFlight.getFlightNumber());
    }

    @Test
    void testFindFlightById() {
        Flight flight = new Flight();
        flight.setId(1);
        flight.setFlightNumber("Flight A");

        flightRepository.save(flight);

        Flight foundFlight = flightRepository.findById(1).orElse(null);

        assertNotNull(foundFlight);
        assertEquals("Flight A", foundFlight.getFlightNumber());
    }
}
