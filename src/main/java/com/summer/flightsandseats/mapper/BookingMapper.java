package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.BookingDTO;
import com.summer.flightsandseats.model.Booking;
import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

// Why not use componentmodel = "spring":
// since you're not using Spring's dependency injection for the mappers, there’s no cyclic dependency between the beans.
// You're relying on manual creation of mappers or invoking the mapping methods directly when needed, which is a good
// solution to avoid circular references.
@Mapper(uses = {FlightMapper.class, SeatMapper.class})
public interface BookingMapper extends IMapper<Booking, BookingDTO> {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "flight.id", target = "flightId")
    @Mapping(source = "seats", target = "seatIds", qualifiedByName = "seatListToIdList")
    BookingDTO toDto(Booking entity);

    @Mapping(source = "flightId", target = "flight", qualifiedByName = "fromId")
    @Mapping(source = "seatIds", target = "seats", qualifiedByName = "idListToSeatList")
    Booking toEntity(BookingDTO dto);

}
