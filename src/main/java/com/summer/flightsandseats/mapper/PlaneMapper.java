package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.PlaneDTO;
import com.summer.flightsandseats.model.Plane;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {SeatMapper.class})
public interface PlaneMapper extends IMapper<Plane, PlaneDTO> {
    PlaneMapper INSTANCE = Mappers.getMapper(PlaneMapper.class);
}
