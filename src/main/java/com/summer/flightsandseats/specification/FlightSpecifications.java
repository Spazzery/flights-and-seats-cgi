package com.summer.flightsandseats.specification;

import com.summer.flightsandseats.model.Flight;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;


// created by Gemini - used for filtering queries inside the DB
public class FlightSpecifications {

    public static Specification<Flight> hasDestination(String destination) {
        return (root, query, criteriaBuilder) ->
                destination == null || destination.isEmpty() ?
                        criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("destination"), destination);
    }

    public static Specification<Flight> hasDate(LocalDate date) {
        return (root, query, criteriaBuilder) ->
                date == null ?
                        criteriaBuilder.conjunction() :
                        criteriaBuilder.equal(root.get("departureDate"), date);
    }

    public static Specification<Flight> hasStartTimeAfter(LocalTime startTime) {
        return (root, query, criteriaBuilder) ->
                startTime == null ?
                        criteriaBuilder.conjunction() :
                        criteriaBuilder.greaterThanOrEqualTo(root.get("departureTime"), startTime);
    }

    public static Specification<Flight> hasEndTimeBefore(LocalTime endTime) {
        return (root, query, criteriaBuilder) ->
                endTime == null ?
                        criteriaBuilder.conjunction() :
                        criteriaBuilder.lessThanOrEqualTo(root.get("departureTime"), endTime);
    }

    public static Specification<Flight> hasMinPrice(Double minPrice) {
        return (root, query, criteriaBuilder) ->
                minPrice == null ?
                        criteriaBuilder.conjunction() :
                        criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Flight> hasMaxPrice(Double maxPrice) {
        return (root, query, criteriaBuilder) ->
                maxPrice == null ?
                        criteriaBuilder.conjunction() :
                        criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Flight> filterFlights(
            String destination,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            Double minPrice,
            Double maxPrice) {
        return Specification
                .where(hasDestination(destination))
                .and(hasDate(date))
                .and(hasStartTimeAfter(startTime))
                .and(hasEndTimeBefore(endTime))
                .and(hasMinPrice(minPrice))
                .and(hasMaxPrice(maxPrice));
    }
}
