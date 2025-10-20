package com.arafat.hospital.controllers;

import com.arafat.hospital.dtos.requestDtos.PatientRequest;
import com.arafat.hospital.dtos.responseDtos.PatientResponse;
import com.arafat.hospital.entities.Insurance;
import com.arafat.hospital.entities.Patient;
import com.arafat.hospital.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> allPatients() {
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(patientService.findById(id), HttpStatus.OK);
    };

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientRequest patient) {
        return new ResponseEntity<>(patientService.createPatient(patient),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(
            @RequestBody PatientRequest patient,
            @PathVariable(name = "id") Long id
    ) {
        return new ResponseEntity<>(patientService.updatePatient(patient, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable(name = "id") Long id) {
        patientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
