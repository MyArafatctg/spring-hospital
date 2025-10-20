package com.arafat.hospital.controllers;

import com.arafat.hospital.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/appointment")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    
}
