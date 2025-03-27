package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.BookingDTO;
import com.summer.flightsandseats.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {FlightMapper.class, SeatMapper.class})
public interface BookingMapper extends IMapper<Booking, BookingDTO> {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "passengerName", target = "passengerName")
    @Mapping(source = "passengerEmail", target = "passengerEmail")
    @Mapping(source = "passengerPhone", target = "passengerPhone")
    @Mapping(source = "bookingTime", target = "bookingTime")
    @Mapping(source = "flight", target = "flight")
    @Mapping(source = "seats", target = "seats")
    Booking toEntity(BookingDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "passengerName", target = "passengerName")
    @Mapping(source = "passengerEmail", target = "passengerEmail")
    @Mapping(source = "passengerPhone", target = "passengerPhone")
    @Mapping(source = "bookingTime", target = "bookingTime")
    @Mapping(source = "flight", target = "flight")
    @Mapping(source = "seats", target = "seats")
    BookingDTO toDto(Booking entity);


}
