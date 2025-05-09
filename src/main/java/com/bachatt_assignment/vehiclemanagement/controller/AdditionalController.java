package com.bachatt_assignment.vehiclemanagement.controller;

import com.bachatt_assignment.vehiclemanagement.dto.ChallanDTO;
import com.bachatt_assignment.vehiclemanagement.dto.InsuranceDTO;
import com.bachatt_assignment.vehiclemanagement.service.ExternalIntegrationService;
import com.bachatt_assignment.vehiclemanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdditionalController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ExternalIntegrationService externalService;

    //get chalan
    @GetMapping("/vehicle/{registrationNo}/chalans")
    public List<ChallanDTO> getChallans(@PathVariable String registrationNo) {
        vehicleService.getVehicleByRegNo(registrationNo);
        return externalService.fetchChallans(registrationNo);
    }
    //get insurance
    @GetMapping("/vehicle/{registrationNo}/insurance")
    public InsuranceDTO getInsurance(@PathVariable String registrationNo) {
        vehicleService.getVehicleByRegNo(registrationNo);
        return externalService.fetchInsurance(registrationNo);
    }
}

