package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.DTO.FlightDTO;
import com.summer.flightsandseats.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

// chatGPT generated
@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    FlightDTO toDTO(Flight flight);
    List<FlightDTO> toDTOList(List<Flight> flights);

    Flight toEntity(FlightDTO flightDTO);
    List<Flight> toEntityList(List<FlightDTO> flightDTOs)
}
