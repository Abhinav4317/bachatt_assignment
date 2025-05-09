package com.bachatt_assignment.vehiclemanagement.dto;


import java.time.LocalDate;

public class InsuranceDTO {
    private String policyNumber;
    private LocalDate expiryDate;

    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }
}
