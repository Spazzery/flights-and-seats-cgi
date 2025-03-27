package com.summer.flightsandseats.service;

import com.summer.flightsandseats.dto.PlaneDTO;
import com.summer.flightsandseats.mapper.PlaneMapper;
import com.summer.flightsandseats.model.Plane;
import com.summer.flightsandseats.repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;


    public List<PlaneDTO> getAllPlanes() {
        List<Plane> planes = planeRepository.findAll();
        return PlaneMapper.INSTANCE.toDTOList(planes);
    }

    public PlaneDTO getPlaneById(Integer id) {
        Plane plane = planeRepository.findById(id).orElse(null);
        return plane != null ? PlaneMapper.INSTANCE.toDto(plane) : null;
    }

    public PlaneDTO savePlane(PlaneDTO planeDTO) {
        Plane plane = PlaneMapper.INSTANCE.toEntity(planeDTO);
        Plane savedPlane = planeRepository.save(plane);
        return PlaneMapper.INSTANCE.toDto(savedPlane);
    }

    public boolean deletePlane(Integer id) {
        if (planeRepository.existsById(id)) {
            planeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
