package com.arafat.hospital.controllers;

import com.arafat.hospital.dtos.requestDtos.DoctorRequest;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;
import com.arafat.hospital.services.DoctorServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
@AllArgsConstructor
public class DoctorController {
    private final DoctorServices doctorServices;

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return new ResponseEntity<>(doctorServices.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id) {
        return new ResponseEntity<>(doctorServices.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> addDoctor(@RequestBody DoctorRequest doctorRequest) {
        return new ResponseEntity<>(doctorServices.create(doctorRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(
            @RequestBody DoctorRequest doctorRequest,
            @PathVariable(name = "id") Long id
    ) {
        return new ResponseEntity<>(doctorServices.update(doctorRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorServices.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
