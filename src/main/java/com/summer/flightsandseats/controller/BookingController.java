package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.model.Booking;
import com.summer.flightsandseats.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Integer id) {
        return bookingService.getBooking(id);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
    }

}
