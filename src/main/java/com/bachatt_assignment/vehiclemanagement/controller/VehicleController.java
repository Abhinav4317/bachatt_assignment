package com.bachatt_assignment.vehiclemanagement.controller;

import com.bachatt_assignment.vehiclemanagement.model.Vehicle;
import com.bachatt_assignment.vehiclemanagement.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    //add vehicle
    @PostMapping("/add/vehicle")
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle) {
        Vehicle created = vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(201).body(created);
    }

    //get all
    @GetMapping("/vehicles")
    public List<Vehicle> getAll() {
        return vehicleService.getAllVehicles();
    }

    //get one
    @GetMapping("/vehicle/{id}")
    public Vehicle getById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    //update
    @PutMapping("/vehicle/{id}")
    public Vehicle update(@PathVariable Long id, @Valid @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    //delete
    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    //fuel/city/state type search
    @GetMapping("/vehicles/search")
    public List<Vehicle> search(
            @RequestParam(required = false) String fuel,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {

        if (fuel != null) {
            return vehicleService.searchByFuel(fuel);
        } else if (city != null) {
            return vehicleService.searchByCity(city);
        } else if (state != null) {
            return vehicleService.searchByState(state);
        } else {
            return vehicleService.getAllVehicles();
        }
    }
}
