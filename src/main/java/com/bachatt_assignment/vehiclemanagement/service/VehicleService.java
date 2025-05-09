package com.bachatt_assignment.vehiclemanagement.service;

import com.bachatt_assignment.vehiclemanagement.exception.ResourceNotFoundException;
import com.bachatt_assignment.vehiclemanagement.model.Vehicle;
import com.bachatt_assignment.vehiclemanagement.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle) {
        if (vehicleRepository.findByRegistrationNo(vehicle.getRegistrationNo()).isPresent()) {
            throw new IllegalArgumentException("Duplicate registration number");
        }
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));
    }

    public Vehicle updateVehicle(Long id, Vehicle updatedVehicle) {
        Vehicle existing = getVehicleById(id);

        existing.setName(updatedVehicle.getName());
        existing.setFuelType(updatedVehicle.getFuelType());
        existing.setRegistrationNo(updatedVehicle.getRegistrationNo());
        existing.setOwnerName(updatedVehicle.getOwnerName());
        existing.setOwnerAddress(updatedVehicle.getOwnerAddress());
        existing.setCity(updatedVehicle.getCity());
        existing.setState(updatedVehicle.getState());

        return vehicleRepository.save(existing);
    }

    public void deleteVehicle(Long id) {
        Vehicle existing = getVehicleById(id);
        vehicleRepository.delete(existing);
    }

    public List<Vehicle> searchByFuel(String fuel) {
        return vehicleRepository.findByFuelType(fuel);
    }

    public List<Vehicle> searchByCity(String city) {
        return vehicleRepository.findByCity(city);
    }

    public List<Vehicle> searchByState(String state) {
        return vehicleRepository.findByState(state);
    }
    public Vehicle getVehicleByRegNo(String regNo) {
        return vehicleRepository.findByRegistrationNo(regNo)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No vehicle found with registration: " + regNo));
    }
}
