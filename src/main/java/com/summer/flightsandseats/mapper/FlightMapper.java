package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.FlightDTO;
import com.summer.flightsandseats.model.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {PlaneMapper.class})
public interface FlightMapper extends IMapper<Flight, FlightDTO> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    @Mapping(source = "plane.id", target = "planeId")  // map only related plane's id to the DTO
    FlightDTO toDto(Flight flight);

    @Mapping(source = "planeId", target = "plane", qualifiedByName = "fromId")
    Flight toEntity(FlightDTO flightDto);

    // AI generated
    @Named("fromId")
    default Flight fromId(Integer id) {
        if (id == null) return null;
        Flight flight = new Flight();
        flight.setId(id);
        return flight;
    }
}
