package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.SeatDTO;
import com.summer.flightsandseats.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlaneMapper.class})
public interface SeatMapper extends IMapper<Seat, SeatDTO> {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "seatNumber", target = "seatNumber")
    @Mapping(source = "seatLetter", target = "seatLetter")
    @Mapping(source = "rowNumber", target = "rowNumber")
    @Mapping(source = "seatType", target = "seatType")
    @Mapping(source = "nextToWindow", target = "nextToWindow")
    @Mapping(source = "nextToAisle", target = "nextToAisle")
    @Mapping(source = "extraLegRoom", target = "extraLegRoom")
    @Mapping(source = "available", target = "available")
    @Mapping(source = "plane", target = "plane")
    Seat toEntity(SeatDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "seatNumber", target = "seatNumber")
    @Mapping(source = "seatLetter", target = "seatLetter")
    @Mapping(source = "rowNumber", target = "rowNumber")
    @Mapping(source = "seatType", target = "seatType")
    @Mapping(source = "nextToWindow", target = "nextToWindow")
    @Mapping(source = "nextToAisle", target = "nextToAisle")
    @Mapping(source = "extraLegRoom", target = "extraLegRoom")
    @Mapping(source = "available", target = "available")
    @Mapping(source = "plane", target = "plane")
    SeatDTO toDto(Seat entity);
}
