package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.FlightDTO;
import com.summer.flightsandseats.dto.PlaneDTO;
import com.summer.flightsandseats.model.Flight;
import com.summer.flightsandseats.model.Plane;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {SeatMapper.class})
public interface PlaneMapper extends IMapper<Plane, PlaneDTO> {
    PlaneMapper INSTANCE = Mappers.getMapper(PlaneMapper.class);

    @Mapping(source = "seats", target = "seatIds", qualifiedByName = "seatListToIdList")
    PlaneDTO toDto(Plane plane);

    @Mapping(source = "seatIds", target = "seats", qualifiedByName = "idListToSeatList")
    Plane toEntity(PlaneDTO planeDto);

    // AI generated
    // Converts Plane ID to Plane object (Needed for Flight toEntity)
    @Named("fromId")
    default Plane fromId(Integer id) {
        if (id == null)
            return null;

        Plane plane = new Plane();
        plane.setId(id);
        return plane;  // return a dummy plane, that fixes issue but also avoids fetching from DB
    }
}
