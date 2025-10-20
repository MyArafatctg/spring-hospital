package com.arafat.hospital.controllers;

import com.arafat.hospital.dtos.requestDtos.DepartmentRequest;
import com.arafat.hospital.dtos.responseDtos.DepartmentResponse;
import com.arafat.hospital.dtos.responseDtos.DoctorResponse;
import com.arafat.hospital.services.DepartmentService;
import com.arafat.hospital.services.DoctorServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dept")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getDepartments() {
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDoctorById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(departmentService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> createDoctor(@RequestBody DepartmentRequest request) {
        return new ResponseEntity<>(departmentService.create(request), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<DepartmentResponse> updateDoctor(
            @RequestBody DepartmentRequest request,
            @PathVariable(name = "id")  Long id
    ) {
        return new ResponseEntity<>(departmentService.update(request,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctorById(@PathVariable(name = "id") Long id) {
        departmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
