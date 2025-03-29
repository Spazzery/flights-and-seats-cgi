package com.summer.flightsandseats.mapper;

import com.summer.flightsandseats.dto.SeatDTO;
import com.summer.flightsandseats.model.Plane;
import com.summer.flightsandseats.model.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {PlaneMapper.class})
public interface SeatMapper extends IMapper<Seat, SeatDTO> {
    SeatMapper INSTANCE = Mappers.getMapper(SeatMapper.class);

    // Take the value from the plane.id field in Seat and map it into SeatDTO's planeId.
    @Mapping(source = "plane.id", target = "planeId")
    SeatDTO toDto(Seat seat);

    // When converting a SeatDTO to a Seat entity, take the planeId field from SeatDTO and convert it into a Plane object in Seat using the fromId method.
    @Mapping(source = "planeId", target = "plane", qualifiedByName = "fromId")
    Seat toEntity(SeatDTO dto);

    // AI generated below
    @Named("fromId")
    default Seat fromId(Integer id) {
        if (id == null) {
            return null;
        }
        Seat seat = new Seat();
        seat.setId(id);
        return seat;
    }

    @Named("seatListToIdList")
    default List<Integer> seatListToIdList(List<Seat> seats) {
        return seats != null ? seats.stream().map(Seat::getId).collect(Collectors.toList()) : null;
    }

    @Named("idListToSeatList")
    default List<Seat> idListToSeatList(List<Integer> seatIds) {
        if (seatIds == null) return null;
        return seatIds.stream().map(this::fromId).collect(Collectors.toList());
    }

}
