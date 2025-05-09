package com.bachatt_assignment.vehiclemanagement.dto;

import java.time.LocalDate;

public class ChallanDTO {
    private String challanNumber;
    private LocalDate date;
    private double amount;
    private String status;

    public String getChallanNumber() { return challanNumber; }
    public void setChallanNumber(String challanNumber) { this.challanNumber = challanNumber; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
