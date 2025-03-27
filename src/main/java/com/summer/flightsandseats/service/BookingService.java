package com.summer.flightsandseats.service;

import com.summer.flightsandseats.dto.BookingDTO;
import com.summer.flightsandseats.mapper.BookingMapper;
import com.summer.flightsandseats.mapper.FlightMapper;
import com.summer.flightsandseats.model.Booking;
import com.summer.flightsandseats.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<BookingDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return BookingMapper.INSTANCE.toDTOList(bookings);
    }

    public BookingDTO getBooking(Integer id) {
        Booking booking = bookingRepository.findById(id).orElse(null);
        return booking != null ? BookingMapper.INSTANCE.toDto(booking) : null;
    }

    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        Booking booking = BookingMapper.INSTANCE.toEntity(bookingDTO);
        Booking savedBooking = bookingRepository.save(booking);
        return BookingMapper.INSTANCE.toDto(savedBooking);
    }

    public boolean deleteBooking(Integer id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
