package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.FlightDTO;
import com.summer.flightsandseats.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlaneMapper.class})
public interface FlightMapper extends IMapper<Flight, FlightDTO> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
}
