package com.summer.flightsandseats.repository;

import com.summer.flightsandseats.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

// jparepository gives built in methods like: findById(), save(), delete(), and findAll().
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>, JpaSpecificationExecutor<Flight> {

    // custom ones
    List<Flight> findByDestination(String destination);

    List<Flight> findByFlightNumber(String flightNumber);
}
