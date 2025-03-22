package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.model.Plane;
import com.summer.flightsandseats.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plane")
public class PlaneController {

    private final PlaneService planeService;

    // DI
    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @GetMapping("/{id}")
    public Optional<Plane> getPlane(@PathVariable Integer id) {
        return planeService.getPlaneById(id);
    }

    @PostMapping
    public Plane savePlane(@RequestBody Plane plane) {
        return planeService.savePlane(plane);
    }

    @DeleteMapping("/{id}")
    public void deletePlane(@PathVariable Integer id) {
        planeService.deletePlane(id);
    }

}
