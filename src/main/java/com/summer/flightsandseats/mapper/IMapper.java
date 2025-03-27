package com.summer.flightsandseats.mapper;

import java.util.List;

public interface IMapper<E, D> {  // Entity, DTO
    D toDto(E entity);
    List<D> toDTOList(List<E> entities);

    E toEntity(D dto);
    List<E> toEntityList(List<D> dtos);
}
