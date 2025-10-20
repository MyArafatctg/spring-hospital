package com.arafat.hospital.controllers;

import com.arafat.hospital.dtos.requestDtos.AppointmentRequest;
import com.arafat.hospital.dtos.requestDtos.PatientAppointmentRequest;
import com.arafat.hospital.dtos.responseDtos.AppointmentResponse;
import com.arafat.hospital.entities.Appointment;
import com.arafat.hospital.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentResponse> getAppointmentById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(appointmentService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        return new ResponseEntity<>(appointmentService.getAppointments(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppointmentResponse> createAppointment(
            @RequestBody AppointmentRequest appointment
    ) {
        return new ResponseEntity<>(appointmentService.create(appointment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponse> updateAppointment(
            @RequestBody AppointmentRequest appointment,
            @PathVariable(name = "id")  Long id
    ){
        return new ResponseEntity<>(appointmentService.update(appointment, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable(name = "id")  Long id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{appointmentId}/assign")
    public ResponseEntity<AppointmentResponse> assignAppointment(
            @RequestBody PatientAppointmentRequest request,
            @PathVariable(name = "appointmentId")   Long appointmentId
            )
    {
        return new ResponseEntity<>(appointmentService.assignAppointment(request,appointmentId), HttpStatus.OK);
    }
}
