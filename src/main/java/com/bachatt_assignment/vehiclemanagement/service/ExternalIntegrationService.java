package com.bachatt_assignment.vehiclemanagement.service;

import com.bachatt_assignment.vehiclemanagement.dto.ChallanDTO;
import com.bachatt_assignment.vehiclemanagement.dto.InsuranceDTO;
import com.bachatt_assignment.vehiclemanagement.exception.ExternalApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ExternalIntegrationService {

    private static final String CHALLAN_API  = "https://example.gov/challans?regNo={reg}";
    private static final String INSURANCE_API = "https://example.gov/insurance/last?regNo={reg}";

    @Autowired
    private RestTemplate restTemplate;

    public List<ChallanDTO> fetchChallans(String registrationNo) {
        try {
            ChallanDTO[] arr = restTemplate.getForObject(CHALLAN_API, ChallanDTO[].class, registrationNo);
            return arr == null ? List.of() : Arrays.asList(arr);
        } catch (RestClientException ex) {
            throw new ExternalApiException("Failed to fetch challans: " + ex.getMessage());
        }
    }

    public InsuranceDTO fetchInsurance(String registrationNo) {
        try {
            return restTemplate.getForObject(INSURANCE_API, InsuranceDTO.class, registrationNo);
        } catch (RestClientException ex) {
            throw new ExternalApiException("Failed to fetch insurance: " + ex.getMessage());
        }
    }
}
