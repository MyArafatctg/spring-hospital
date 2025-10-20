package com.arafat.hospital.dtos.responseDtos;

import com.arafat.hospital.entities.Doctor;
import com.arafat.hospital.entities.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentDate;
    private String reason;
    private Patient patient;
    private Doctor doctor;

}
