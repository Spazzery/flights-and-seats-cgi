package com.summer.flightsandseats.service;

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

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public Optional<Plane> getPlaneById(Integer id) {
        return planeRepository.findById(id);
    }

    public Plane savePlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public void deletePlane(Integer id) {
        planeRepository.deleteById(id);
    }

}
