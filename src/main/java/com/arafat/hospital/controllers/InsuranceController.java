package com.arafat.hospital.controllers;

import com.arafat.hospital.dtos.requestDtos.InsuranceRequest;
import com.arafat.hospital.dtos.responseDtos.InsuranceResponse;
import com.arafat.hospital.entities.Insurance;
import com.arafat.hospital.services.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/insurance")
@AllArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    @PostMapping
    public ResponseEntity<InsuranceResponse> createInsurance(
            @RequestBody InsuranceRequest request
    ) {
        return new ResponseEntity<>(insuranceService.createInsurance(request), HttpStatus.CREATED);
    }
}
