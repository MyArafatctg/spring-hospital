package com.arafat.hospital.controllers;

import com.arafat.hospital.dtos.requestDtos.InsuranceRequest;
import com.arafat.hospital.dtos.responseDtos.InsuranceResponse;
import com.arafat.hospital.entities.Insurance;
import com.arafat.hospital.services.InsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/insurance")
@AllArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping
    public ResponseEntity<List<InsuranceResponse>> getAllInsurances(){
        return new ResponseEntity<>(insuranceService.getInsurances(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceResponse> getInsuranceById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(insuranceService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<InsuranceResponse> createInsurance(
            @RequestBody InsuranceRequest request
    ) {
        return new ResponseEntity<>(insuranceService.createInsurance(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceResponse> updateInsurance(
            @RequestBody InsuranceRequest request,
            @PathVariable(name = "id") Long id
    ){
        return new ResponseEntity<>(insuranceService.updateInsurance(request,id),HttpStatus.OK);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable(name = "id") Long id){
        insuranceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    };
}
