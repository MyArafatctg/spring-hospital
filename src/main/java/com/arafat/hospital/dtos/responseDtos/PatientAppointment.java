package com.arafat.hospital.dtos.responseDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PatientAppointment {
    private Long id;
    private LocalDateTime appointmentDate;
    private String reason;
    private AppointentDoctor doctor;
}
