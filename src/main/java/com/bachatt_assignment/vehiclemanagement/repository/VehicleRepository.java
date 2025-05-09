package com.bachatt_assignment.vehiclemanagement.repository;

import com.bachatt_assignment.vehiclemanagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> findByRegistrationNo(String registrationNo);

    List<Vehicle> findByFuelType(String fuelType);

    List<Vehicle> findByCity(String city);

    List<Vehicle> findByState(String state);
}
