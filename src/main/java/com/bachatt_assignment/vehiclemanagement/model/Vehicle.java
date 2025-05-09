package com.bachatt_assignment.vehiclemanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "vehicles", uniqueConstraints = {@UniqueConstraint(columnNames = "registrationNo")})
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String fuelType;

    @NotBlank
    @Column(unique = true)
    private String registrationNo;

    @NotBlank
    private String ownerName;

    @NotBlank
    private String ownerAddress;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}
