package com.summer.flightsandseats.controller;

import com.summer.flightsandseats.dto.PlaneDTO;
import com.summer.flightsandseats.model.Plane;
import com.summer.flightsandseats.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    private final PlaneService planeService;

    // Dependency Injection
    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public ResponseEntity<List<PlaneDTO>> getAllPlanes() {
        List<PlaneDTO> planes = planeService.getAllPlanes();

        if (planes.isEmpty()) {
            return ResponseEntity.noContent().build(); // Return 204 if no planes
        }
        return ResponseEntity.ok(planes); // Return 200 with plane list
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaneDTO> getPlaneById(@PathVariable Integer id) {
        PlaneDTO plane = planeService.getPlaneById(id);

        if (plane == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plane, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlaneDTO> savePlane(@RequestBody PlaneDTO planeDTO) {
        PlaneDTO createdPlane = planeService.savePlane(planeDTO);
        return new ResponseEntity<>(createdPlane, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlane(@PathVariable Integer id) {
        boolean deleted = planeService.deletePlane(id);

        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
