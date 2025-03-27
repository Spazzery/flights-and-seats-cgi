package com.summer.flightsandseats.service;

import com.summer.flightsandseats.dto.SeatDTO;
import com.summer.flightsandseats.mapper.SeatMapper;
import com.summer.flightsandseats.model.Seat;
import com.summer.flightsandseats.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;

    public List<SeatDTO> getAllSeats() {
        List<Seat> seats = seatRepository.findAll();
        return SeatMapper.INSTANCE.toDTOList(seats);
    }

    public SeatDTO getSeatById(Integer id) {
        Seat seat = seatRepository.findById(id).orElse(null);
        return seat != null ? SeatMapper.INSTANCE.toDto(seat) : null;
    }

    public SeatDTO saveSeat(SeatDTO seatDTO) {
        Seat seat = SeatMapper.INSTANCE.toEntity(seatDTO);
        Seat savedSeat = seatRepository.save(seat);
        return SeatMapper.INSTANCE.toDto(savedSeat);
    }

    public boolean deleteSeat(Integer id) {
        if (seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
