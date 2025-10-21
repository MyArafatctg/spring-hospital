package com.arafat.hospital.dtos.requestDtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PatientAppointmentUpdate {
    private LocalDateTime appointmentDate;
    private String reason;
}
